package P3;

import java.util.ArrayList;

public class Action {
	private final ArrayList<String> historys = new ArrayList<>();
	int historycounter = 0;
	// Abstraction function:
	// ��һ���ó�����������ģ��ĸ��ֲ�������ʵ���嶯���ĳ�����

	// Representation invariant:
	// ÿ�����������в���ѡ�֣���������Ϊ�գ�����λ�ñ���Ϸ���

	// Safety from rep exposure:
	// ����historysΪprivate final
	// ���б�Ҫ��ʱ��ʹ�÷����Կ���
	/**
	 * ��������
	 * 
	 * @param player ����ѡ��
	 * @param board  ����������
	 * @param piece  ���õ�����
	 * @return
	 */
	public boolean putPiece(Player player, Board board, Piece piece) {
		boolean flag = board.putPiece(piece);
		if (flag) {
			historys.add(historycounter + ". " + player.getPlayerName() + " add a " + piece.getName() + " piece to ("
					+ piece.getPosition().getPx() + "," + piece.getPosition().getPy() + ").");
			historycounter++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �Ƴ�����
	 * 
	 * @param player ����ѡ��
	 * @param board  ����������
	 * @param piece  �Ƴ������ӵ�λ��
	 * @return
	 */
	public boolean removePiece(Player player, Board board, Position position) {
		boolean flag = board.removePiece(position);
		if (flag) {
			historys.add(historycounter + ". " + player.getPlayerName() + " remove the piece at (" + position.getPx()
					+ "," + position.getPy() + ").");
			historycounter++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param board����������
	 * @param position   ����λ��
	 * @return
	 */
	public String checkPos(Board board, Position position) {
		return board.checkPos(position);
	}

	/**
	 * @param board ����������
	 * @return ����˵��˫��������Ŀ���ַ���
	 */
	public String countPiece(Board board) {
		return board.countPiece();
	}

	/**
	 * �����¼������ʷ������
	 */
	public void printHistory() {
		for (String s : historys) {
			System.out.println(s);
		}
	}

	/**
	 * @param player ���������
	 * @param board  ����������
	 * @param p1     ��ʼλ��
	 * @param p2     ��ֹλ��
	 * @return
	 */
	public boolean move(Player player, Board board, Position p1, Position p2) {
		boolean flag = board.move(player, p1, p2);
		if (flag) {
			historys.add(historycounter + ". " + player.getPlayerName() + " move the piece at (" + p1.getPx() + ","
					+ p1.getPy() + ") to position (" + p2.getPx() + "," + p2.getPy() + ")");
			historycounter++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param player���������
	 * @param board       ����������
	 * @param p1          ��ʼλ��
	 * @param p2          ��ֹλ��
	 * @return ����ֵ �ɹ����
	 */
	public boolean eat(Player player, Board board, Position p1, Position p2) {
		boolean flag = board.eat(player, p1, p2);
		if (flag) {
			historys.add(historycounter + ". " + player.getPlayerName() + " move the piece at (" + p1.getPx() + ","
					+ p1.getPy() + ") to position (" + p2.getPx() + "," + p2.getPy() + ")");
			historycounter++;
			return true;
		} else {
			return false;
		}
	}
}
