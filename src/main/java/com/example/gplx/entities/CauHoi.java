package com.example.gplx.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CauHoi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maCauHoi")
	private int maCauHoi;

	@Column(name = "cauHoi", nullable = false, length = 255, columnDefinition = "varchar(255)")
	private String cauHoi;

	@Column(name = "hinhAnh", nullable = true, length = 255, columnDefinition = "varchar(255)")
	private String hinhAnh;

	@Column(name = "loaiCauHoi", nullable = false, length = 255, columnDefinition = "varchar(255)")
	private String loaiCauHoi;

	public int getMaCauHoi() {
		return maCauHoi;
	}

	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public String getCauHoi() {
		return cauHoi;
	}

	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getLoaiCauHoi() {
		return loaiCauHoi;
	}

	public void setLoaiCauHoi(String loaiCauHoi) {
		this.loaiCauHoi = loaiCauHoi;
	}
}
