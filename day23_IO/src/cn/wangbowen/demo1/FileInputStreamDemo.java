package cn.wangbowen.demo1;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStream ��ȡ�ļ�
 *
 * ���裺
 *      1.�����ֽ����������Ӷ���
 *      2.����read����
 *      3.�ر���Դ
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        // ���ڽ���read����ֵ��ÿ��read��������ƶ�
        int len = 0;
        // ����-1��ʱ���ļ���ȡ����
        while((len = fis.read()) != -1) {
            // ���ص���int��ASCII��ǿת��char
            System.out.print((char) len);
        }
        System.out.println("�ļ���ȡ��Ϻ��ٴζ�ȡ��" + fis.read());
        System.out.println("��Ϊ��������Ĭ����UTF-8������ȡ���ļ���BGK�������ĳ�������");
        System.out.println("���Ҫ�ı�������������Ҫ���ַ�����ת��");

        // �ر���Դ
        fis.close();
    }
}
