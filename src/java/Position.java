package P3;

public class Position {

	private int Px;
	private int Py; // ��������

	/**
	 * ���췽��
	 * @param px x����
	 * @param py y����
	 */
	public Position(int px, int py) {
		this.Px = px;
		this.Py = py;
	}

	/**
	 * @return ��ǰ��x
	 */
	public int getPx() {
		return Px;
	}

	/**
	 * @return ��ǰ��y
	 */
	public int getPy() {
		return Py;
	}

	/**
	 * �жϵ�ǰλ����Ŀ��λ���Ƿ����
	 * @param a �Ƚ϶���
	 * @return ����ֵ��������
	 */
	public boolean equals(Position P) {
		if (P.Px == this.Px && P.Py == this.Py)
			return true;
		else
			return false;
	}
}
