package com.example.gplx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gplx.entities.Question;
import com.example.gplx.repository.QuestionRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class docFileService {

    @Autowired
    private QuestionRepository questionRepository;

    public void saveQuestionsFromTxt(String filePath) throws IOException {
        List<Question> questions = new ArrayList<>();

        // Đọc file từ đường dẫn tuyệt đối
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Question currentQuestion = null;
            StringBuilder questionText = new StringBuilder();
            String option1 = null;
            String option2 = null;
            String option3 = null;
            String option4 = null;
            String correctAnswer = null;
            String questionType = null;
            String explanation = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Kiểm tra nếu là câu hỏi mới (bắt đầu với "Câu")
                if (line.startsWith("Câu")) {
                    // Nếu đã có câu hỏi trước đó, lưu vào danh sách
                    if (currentQuestion != null) {
                        // Kiểm tra nếu câu hỏi đã tồn tại trong cơ sở dữ liệu
                        if (!isQuestionExist(currentQuestion.getQuestionText())) {
                            currentQuestion.setQuestionText(questionText.toString());
                            currentQuestion.setOption1(option1);
                            currentQuestion.setOption2(option2);
                            currentQuestion.setOption3(option3);
                            currentQuestion.setOption4(option4);
                            currentQuestion.setCorrectAnswer(correctAnswer);
                            currentQuestion.setQuestionType(questionType);
                            currentQuestion.setExplanation(explanation);
                            questions.add(currentQuestion);
                        }
                    }

                    // Tạo câu hỏi mới
                    currentQuestion = new Question();
                    questionText = new StringBuilder(); // Reset câu hỏi
                    option1 = null; // Reset lựa chọn 1
                    option2 = null; // Reset lựa chọn 2
                    option3 = null; // Reset lựa chọn 3
                    option4 = null; // Reset lựa chọn 4
                    correctAnswer = null; // Reset đáp án
                    questionType = null; // Reset loại câu hỏi
                    explanation = null; // Reset giải thích
                }

                // Lưu câu hỏi vào questionText
                if (line.startsWith("Câu")) {
                    questionText.append(line).append("\n");
                }

                // Lưu các lựa chọn vào option1, option2, option3, option4
                else if (line.startsWith("1.")) {
                    option1 = line.substring(3).trim(); // Bỏ "1." và lưu lựa chọn
                } else if (line.startsWith("2.")) {
                    option2 = line.substring(3).trim(); // Bỏ "2." và lưu lựa chọn
                } else if (line.startsWith("3.")) {
                    option3 = line.substring(3).trim(); // Bỏ "3." và lưu lựa chọn
                } else if (line.startsWith("4.")) {
                    option4 = line.substring(3).trim(); // Bỏ "4." và lưu lựa chọn
                }

                // Lưu đáp án vào correctAnswer
                else if (line.startsWith("Đáp án:")) {
                    correctAnswer = line.substring(8).trim(); // Lấy đáp án
                }

                // Lưu loại câu hỏi
                else if (line.startsWith("Loại câu hỏi:")) {
                    questionType = line.substring(14).trim();
                }

                // Lưu giải thích
                else if (line.startsWith("Giải thích:")) {
                    explanation = line.substring(12).trim();
                }
            }

            // Lưu câu hỏi cuối cùng (nếu có)
            if (currentQuestion != null) {
                // Kiểm tra nếu câu hỏi đã tồn tại trong cơ sở dữ liệu
                if (!isQuestionExist(currentQuestion.getQuestionText())) {
                    currentQuestion.setQuestionText(questionText.toString());
                    currentQuestion.setOption1(option1);
                    currentQuestion.setOption2(option2);
                    currentQuestion.setOption3(option3);
                    currentQuestion.setOption4(option4);
                    currentQuestion.setCorrectAnswer(correctAnswer);
                    currentQuestion.setQuestionType(questionType);
                    currentQuestion.setExplanation(explanation);
                    questions.add(currentQuestion);
                }
            }
        }

        // Lưu tất cả câu hỏi vào DB
        if (!questions.isEmpty()) {
            questionRepository.saveAll(questions);
        }
    }

    // Kiểm tra câu hỏi đã tồn tại trong cơ sở dữ liệu
    private boolean isQuestionExist(String questionText) {
        return questionRepository.existsByQuestionText(questionText);
    }
}
