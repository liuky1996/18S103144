package P3;

public class Piece {

	private final String pieceName; // ��������
	private Position piecePosition;// ����λ��
	private final int owner;// ����������

	/**
	 * ���췽��
	 * 
	 * @param pieceState �������ӵ�״̬
	 * @param pieceName  �������ӵ�����
	 * @param owner      ������
	 */
	public Piece(String pieceName, int owner) {
		this.pieceName = pieceName;
		this.owner = owner;
	}

	/**
	 * @return �������ӵ�������
	 */
	public int getOwner() {
		return owner;
	}

	/**
	 * @return �������ӵ�����
	 */
	public String getName() {
		return this.pieceName;
	}

	/**
	 * @return �������ӵ�λ��
	 */
	public Position getPosition() {
		return this.piecePosition;
	}

	/**
	 * @param x λ�ò���
	 * @param y λ�ò���
	 */
	public void setPosition(Integer x, Integer y) {
		this.piecePosition = new Position(x, y);
	}

}
