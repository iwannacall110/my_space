package com.wangshan.service;

import com.wangshan.models.User;

/**
 * ��֤����, ����������Ϣ�����ṩֱ�Ӳ�ѯ�ӿڣ�ֻ�ṩ��֤�ӿ�
 * Created by shan on 2015/12/3.
 */
public interface ValidateService {
    /**
     * ��֤�û�
     * @param password
     * @return
     */
    public Boolean validatePassword(String email, String password);

    public Boolean validateMobileRepeat(String mobile);

    public Boolean validateEmailRepeat(String email);
}
