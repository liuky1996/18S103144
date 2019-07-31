package P3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Board {
	private int boardSize;
	private final Set<Piece> boardSet = new HashSet<>();
	public String playerA;
	public String playerB;
		// Abstraction function:
		// ��һ��������һ��Piece����boardSet��������̣�����ʵ���̵�ӳ��

		// Representation invariant:
		// ������������������̴�СboardSize��Χ�ڣ�ÿ�α�������Ϸ���λ�ã�һ��λ�ò�������ö����

		// Safety from rep exposure:
		// ����boardSetΪprivate final
		// ���б�Ҫ��ʱ��ʹ�÷����Կ���
	/**
	 * @return ����boardSet�������
	 */
	public Set<Piece> getBoardSet() {
		return boardSet;
	}

	/**
	 * ���췽��
	 * 
	 * @param Type ��������
	 */
	public Board(String Type) {
		if (Type.equals("a")) {
			boardSize = 7;
		} else {
			boardSize = 18;
		}
	}

	/**
	 * @param piece Ҫ���õ�����
	 * @return �ɹ�����true ���� false
	 */
	public boolean putPiece(Piece piece) {
		int px = piece.getPosition().getPx();
		int py = piece.getPosition().getPy();
		if (px < 0 || px > boardSize || py < 0 || py > boardSize) {
			System.out.println("����λ�ó�����Χ");
			return false;
		}
		Iterator<Piece> it = boardSet.iterator();
		while (it.hasNext()) {
			Piece p = it.next();
			if (p.getPosition().getPx() == px && p.getPosition().getPy() == py) {
				System.out.println("���󣺸�λ������Ԫ��");
				return false;
			}
		}
		return boardSet.add(piece);
	}

	/**
	 * ȷ��ĳλ��P�Ƿ�Խ��
	 * 
	 * @param PҪȷ�ϵ�λ�ò���
	 * @return �Ƿ���Ч����Чtrue ���� false
	 */
	public boolean checkPosivalid(Position P) {
		if (P.getPx() < 0 || P.getPy() < 0 || P.getPx() > boardSize || P.getPy() > boardSize) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * �Ƴ�ĳλ��Ԫ��
	 * 
	 * @param P λ��
	 * @return �ɹ�����true ���� false
	 */
	public boolean removePiece(Position P) {
		if (!checkPosivalid(P)) {
			System.out.println("����λ�ó�����Χ");
			return false;
		}
		Iterator<Piece> it = boardSet.iterator();
		while (it.hasNext()) {
			Piece p = it.next();
			if (p.getPosition().getPx() == P.getPx() && p.getPosition().getPy() == P.getPy()) {
				it.remove();
				System.out.println("�Ƴ��ɹ�");
				return true;
			}
		}
		System.out.println("���󣺸�λ����Ԫ��");
		return false;
	}

	/**
	 * ��������ĳ��λ�õ�string
	 * 
	 * @param P λ��
	 * @return ����ĳ��λ�õ��ַ���
	 */
	public String checkPos(Position P) {
		if (!checkPosivalid(P)) {
			return "����Խ��";
		}
		Iterator<Piece> it = boardSet.iterator();
		while (it.hasNext()) {
			Piece p = it.next();
			if (p.getPosition().getPx() == P.getPx() && p.getPosition().getPy() == P.getPy()) {
				if (p.getOwner() == 0) {
					return "�ô��ѱ�ѡ��" + playerA + "�����ӣ�" + p.getName() + "ռ��";
				} else {
					return "�ô��ѱ�ѡ��" + playerB + "�����ӣ�" + p.getName() + "ռ��";
				}
			}
		}
		return "����";
	}

	/**
	 * ͳ��˫�����е���������
	 * 
	 * @return ��¼˫��������Ŀ���ַ���
	 */
	public String countPiece() {
		Iterator<Piece> it = boardSet.iterator();
		int countA = 0;
		int countB = 0;
		while (it.hasNext()) {
			Piece p = it.next();
			if (p.getOwner() == 0) {
				countA++;
			}
			if (p.getOwner() == 1) {
				countB++;
			}
		}
		return playerA + " has " + countA + " pieces, and " + playerB + " has " + countB + " pieces.";
	}

	/**
	 * �鿴һ��λ���Ƿ�Ϊ��
	 * 
	 * @param P λ��
	 * @return �շ���true �ǿշ���false
	 */
	public boolean checkPosempty(Position P) {
		Iterator<Piece> it1 = boardSet.iterator();
		while (it1.hasNext()) {
			Piece p = it1.next();
			if (p.getPosition().getPx() == P.getPx() && p.getPosition().getPy() == P.getPy()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * �ƶ�����
	 * 
	 * @param player ������
	 * @param p1     ��ʼ��
	 * @param p2     ��ֹ��
	 * @return �ɹ�����true ���� false
	 */
	public boolean move(Player player, Position p1, Position p2) {
		if (!checkPosivalid(p1) || !checkPosivalid(p2)) {
			System.out.println("����λ�ó�����Χ");
			return false;
		}
		if (!checkPosempty(p2)) {
			System.out.println("Ŀ��λ����ռ��");
			return false;
		}
		Iterator<Piece> it = boardSet.iterator();
		while (it.hasNext()) {
			Piece p = it.next();
			if (p.getPosition().getPx() == p1.getPx() && p.getPosition().getPy() == p1.getPy()) {
				if (p.getOwner() != player.getPlayerTurn()) {
					System.out.println("�ⲻ���������");
					return false;
				} else {
					p.setPosition(p2.getPx(), p2.getPy());
					System.out.println("�ƶ��ɹ�");
					return true;
				}
			}
		}
		System.out.println("û������");
		return false;
	}

	/**
	 * ����
	 * 
	 * @param player ������
	 * @param p1     ��ʼ��
	 * @param p2     ��ֹ��
	 * @return �ɹ�����true ���� false
	 */
	public boolean eat(Player player, Position p1, Position p2) {
		Piece target = null;
		Piece start = null;
		if (!checkPosivalid(p1) || !checkPosivalid(p2)) {
			System.out.println("����λ�ó�����Χ");
			return false;
		}
		if (p1.equals(p2)) {
			System.out.println("����ǰ���ַ��ͬ");
			return false;
		}
		Iterator<Piece> it1 = boardSet.iterator();
		while (it1.hasNext()) {
			Piece p = it1.next();
			if (p.getPosition().getPx() == p2.getPx() && p.getPosition().getPy() == p2.getPy()) {
				if (p.getOwner() == player.getPlayerTurn()) {
					System.out.println("����������Ӳ��ܳ�");
					return false;
				} else
					target = p;
			}
			if (p.getPosition().getPx() == p1.getPx() && p.getPosition().getPy() == p1.getPy()) {
				if (p.getOwner() != player.getPlayerTurn()) {
					System.out.println("�ⲻ��������Ӳ��ܶ�");
					return false;
				} else {
					start = p;
				}
			}
		}
		if (target == null) {
			System.out.println("Ŀ�����Ԫ��");
			return false;
		}
		if (start == null) {
			System.out.println("��ʼ����Ԫ��");
			return false;
		}
		boardSet.remove(target);
		start.setPosition(p2.getPx(), p2.getPy());
		System.out.println("���ӳɹ�");
		return true;
	}
}
