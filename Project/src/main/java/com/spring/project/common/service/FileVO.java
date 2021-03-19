package com.spring.project.common.service;

import java.io.Serializable;

public class FileVO implements Serializable {

    /**
	 *  serialVersion UID
	 */
	private static final long serialVersionUID = -287950405903719128L;
	/**
     * ÷������ ���̵�
     */
    public String atchFileId = "";
    /**
     * ��������
     */
    public String creatDt = "";
    /**
     * ���ϳ���
     */
    public String fileCn = "";
    /**
     * ����Ȯ����
     */
    public String fileExtsn = "";
    /**
     * ����ũ��
     */
    public String fileMg = "";
    /**
     * ���Ͽ���
     */
    public String fileSn = "";
    /**
     * ����������
     */
    public String fileStreCours = "";
    /**
     * �����ϸ�
     */
    public String orignlFileNm = "";
    /**
     * �������ϸ�
     */
    public String streFileNm = "";
    
    public String sync = "";

    /**
     * atchFileId attribute�� �����Ѵ�.
     *
     * @return the atchFileId
     */
    public String getAtchFileId() {
	return atchFileId;
    }

    /**
     * atchFileId attribute ���� �����Ѵ�.
     *
     * @param atchFileId
     *            the atchFileId to set
     */
    public void setAtchFileId(String atchFileId) {
	this.atchFileId = atchFileId;
    }

    /**
     * creatDt attribute�� �����Ѵ�.
     *
     * @return the creatDt
     */
    public String getCreatDt() {
	return creatDt;
    }

    /**
     * creatDt attribute ���� �����Ѵ�.
     *
     * @param creatDt
     *            the creatDt to set
     */
    public void setCreatDt(String creatDt) {
	this.creatDt = creatDt;
    }

    /**
     * fileCn attribute�� �����Ѵ�.
     *
     * @return the fileCn
     */
    public String getFileCn() {
	return fileCn;
    }

    /**
     * fileCn attribute ���� �����Ѵ�.
     *
     * @param fileCn
     *            the fileCn to set
     */
    public void setFileCn(String fileCn) {
	this.fileCn = fileCn;
    }

    /**
     * fileExtsn attribute�� �����Ѵ�.
     *
     * @return the fileExtsn
     */
    public String getFileExtsn() {
	return fileExtsn;
    }

    /**
     * fileExtsn attribute ���� �����Ѵ�.
     *
     * @param fileExtsn
     *            the fileExtsn to set
     */
    public void setFileExtsn(String fileExtsn) {
	this.fileExtsn = fileExtsn;
    }

    /**
     * fileMg attribute�� �����Ѵ�.
     *
     * @return the fileMg
     */
    public String getFileMg() {
	return fileMg;
    }

    /**
     * fileMg attribute ���� �����Ѵ�.
     *
     * @param fileMg
     *            the fileMg to set
     */
    public void setFileMg(String fileMg) {
	this.fileMg = fileMg;
    }

    /**
     * fileSn attribute�� �����Ѵ�.
     *
     * @return the fileSn
     */
    public String getFileSn() {
	return fileSn;
    }

    /**
     * fileSn attribute ���� �����Ѵ�.
     *
     * @param fileSn
     *            the fileSn to set
     */
    public void setFileSn(String fileSn) {
	this.fileSn = fileSn;
    }

    /**
     * fileStreCours attribute�� �����Ѵ�.
     *
     * @return the fileStreCours
     */
    public String getFileStreCours() {
	return fileStreCours;
    }

    /**
     * fileStreCours attribute ���� �����Ѵ�.
     *
     * @param fileStreCours
     *            the fileStreCours to set
     */
    public void setFileStreCours(String fileStreCours) {
	this.fileStreCours = fileStreCours;
    }

    /**
     * orignlFileNm attribute�� �����Ѵ�.
     *
     * @return the orignlFileNm
     */
    public String getOrignlFileNm() {
	return orignlFileNm;
    }

    /**
     * orignlFileNm attribute ���� �����Ѵ�.
     *
     * @param orignlFileNm
     *            the orignlFileNm to set
     */
    public void setOrignlFileNm(String orignlFileNm) {
	this.orignlFileNm = orignlFileNm;
    }

    /**
     * streFileNm attribute�� �����Ѵ�.
     *
     * @return the streFileNm
     */
    public String getStreFileNm() {
	return streFileNm;
    }

    /**
     * streFileNm attribute ���� �����Ѵ�.
     *
     * @param streFileNm
     *            the streFileNm to set
     */
    public void setStreFileNm(String streFileNm) {
	this.streFileNm = streFileNm;
    }
        
    public String getSync() {
		return sync;
	}

	public void setSync(String sync) {
		this.sync = sync;
	}

}
