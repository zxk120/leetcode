package exercise1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixDN {

    //���㼯��
    private ListNode[] vertexs;

    /*
     * ����ͼ(�Լ���������)
     */
    public MatrixDN() {
        Scanner scanner = new Scanner(System.in);
        // ����"������"��"����"
        System.out.printf("input vertex number: ");
        int vlen = scanner.nextInt();
        System.out.printf("input edge number: ");
        int elen = scanner.nextInt();
        if (vlen < 1 || elen < 1 || (elen > (vlen * (vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return;
        }

        // ��ʼ��"����"
        vertexs = new ListNode[vlen];
        System.out.printf("vertexs (�Զ��ŷָ�): ");
        String s = scanner.next();
        String[] values = s.split(",");
        for (int i = 0; i < vertexs.length; i++) {
            ListNode listNode = new ListNode(values[i]);
            vertexs[i] = listNode;
        }

        // ��ʼ��"��"
        System.out.println("��������ʼ���������Զ��ŷָ�");
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            System.out.printf("��ʼ����������: ");
            String string = scanner.next();
            Object[] c = string.split(",");
            ListNode p1 = getPostion(c[0]);
            System.out.printf("Ȩ��: ");
            ListNode p2 = new ListNode(c[1], scanner.nextInt());
            ListHelper listHelper = new ListHelper();
            listHelper.addListNode(p1, p2);

            if (p1 == null || p2 == null) {
                System.out.printf("input error: invalid edge!\n");
                return;
            }
        }
    }

    public ListNode getPostion(Object v) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i].val.equals(v)) {
                return vertexs[i];
            }
        }
        return null;
    }

    public int getNum(ListNode[] vertexs, Object val) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i].val.equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MatrixDN dn = new MatrixDN();
        for (int i = 0; i < dn.vertexs.length; i++) {
            ListHelper listHelper = new ListHelper();
            listHelper.printList(dn.vertexs[i]);
            System.out.println("   ");
        }

        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.getMinWeight(dn.vertexs));
        System.out.println(dijkstra.minPath);

    }

}