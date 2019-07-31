package P3;

public class Game {
	private Board gameBoard;
	private final Action gameAction = new Action();
	private final Player PlayerA = new Player();
	private final Player PlayerB = new Player();

	/**
	 * @return �������̶���
	 */
	public Board getGameBoard() {
		return gameBoard;
	}

	/**
	 * @return ����ѡ��A
	 */
	public Player getPlayerA() {
		return PlayerA;
	}

	/**
	 * @return ����ѡ��B
	 */
	public Player getPlayerB() {
		return PlayerB;
	}

	/**
	 * get��ǰѡ��
	 * 
	 * @param turn �غϱ�ʶ��
	 * @return ��ǰ�غ�Ӧ���ж���ѡ��
	 */
	public Player getPlayer(int turn) {
		if (turn == 0) {
			return PlayerA;
		} else {
			return PlayerB;
		}
	}

	/**
	 * ��ʼ������
	 * 
	 * @param type Ҫ��ʼ������������
	 */
	public Game(String type) {
		if (type.equals("a")) {
			gameBoard = new Board("a");// ����a�����������
			Piece King0 = new Piece("King", 0);
			King0.setPosition(4, 0);
			Piece King1 = new Piece("King", 1);
			King1.setPosition(4, 7);
			Piece Queen0 = new Piece("Queen", 0);
			Queen0.setPosition(3, 0);
			Piece Queen1 = new Piece("Queen", 1);
			Queen1.setPosition(3, 7);
			Piece Rook1 = new Piece("Rook", 0);
			Rook1.setPosition(0, 0);
			Piece Rook2 = new Piece("Rook", 0);
			Rook2.setPosition(7, 0);
			Piece Rook3 = new Piece("Rook", 1);
			Rook3.setPosition(0, 7);
			Piece Rook4 = new Piece("Rook", 1);
			Rook4.setPosition(7, 7);

			Piece Knight1 = new Piece("Knight", 0);
			Knight1.setPosition(1, 0);
			Piece Knight2 = new Piece("Knight", 0);
			Knight2.setPosition(6, 0);
			Piece Knight3 = new Piece("Knight", 1);
			Knight3.setPosition(1, 7);
			Piece Knight4 = new Piece("Knight", 1);
			Knight4.setPosition(6, 7);

			Piece Bishop1 = new Piece("Bishop", 0);
			Bishop1.setPosition(2, 0);
			Piece Bishop2 = new Piece("Bishop", 0);
			Bishop2.setPosition(5, 0);
			Piece Bishop3 = new Piece("Bishop", 1);
			Bishop3.setPosition(2, 7);
			Piece Bishop4 = new Piece("Bishop", 1);
			Bishop4.setPosition(5, 7);

			Piece Pawn1 = new Piece("Pawn", 0);
			Pawn1.setPosition(0, 1);
			Piece Pawn2 = new Piece("Pawn", 0);
			Pawn2.setPosition(1, 1);
			Piece Pawn3 = new Piece("Pawn", 0);
			Pawn3.setPosition(2, 1);
			Piece Pawn4 = new Piece("Pawn", 0);
			Pawn4.setPosition(3, 1);
			Piece Pawn5 = new Piece("Pawn", 0);
			Pawn5.setPosition(4, 1);
			Piece Pawn6 = new Piece("Pawn", 0);
			Pawn6.setPosition(5, 1);
			Piece Pawn7 = new Piece("Pawn", 0);
			Pawn7.setPosition(6, 1);
			Piece Pawn8 = new Piece("Pawn", 0);
			Pawn8.setPosition(7, 1);

			Piece Pawn9 = new Piece("Pawn", 1);
			Pawn9.setPosition(0, 6);
			Piece Pawn10 = new Piece("Pawn", 1);
			Pawn10.setPosition(1, 6);
			Piece Pawn11 = new Piece("Pawn", 1);
			Pawn11.setPosition(2, 6);
			Piece Pawn12 = new Piece("Pawn", 1);
			Pawn12.setPosition(3, 6);
			Piece Pawn13 = new Piece("Pawn", 1);
			Pawn13.setPosition(4, 6);
			Piece Pawn14 = new Piece("Pawn", 1);
			Pawn14.setPosition(5, 6);
			Piece Pawn15 = new Piece("Pawn", 1);
			Pawn15.setPosition(6, 6);
			Piece Pawn16 = new Piece("Pawn", 1);
			Pawn16.setPosition(7, 6);
			gameBoard.putPiece(Queen0);
			gameBoard.putPiece(Queen1);
			gameBoard.putPiece(King0);
			gameBoard.putPiece(King1);

			gameBoard.putPiece(Knight1);
			gameBoard.putPiece(Knight2);
			gameBoard.putPiece(Knight3);
			gameBoard.putPiece(Knight4);

			gameBoard.putPiece(Rook1);
			gameBoard.putPiece(Rook2);
			gameBoard.putPiece(Rook3);
			gameBoard.putPiece(Rook4);

			gameBoard.putPiece(Bishop1);
			gameBoard.putPiece(Bishop2);
			gameBoard.putPiece(Bishop3);
			gameBoard.putPiece(Bishop4);

			gameBoard.putPiece(Pawn1);
			gameBoard.putPiece(Pawn2);
			gameBoard.putPiece(Pawn3);
			gameBoard.putPiece(Pawn4);
			gameBoard.putPiece(Pawn5);
			gameBoard.putPiece(Pawn6);
			gameBoard.putPiece(Pawn7);
			gameBoard.putPiece(Pawn8);
			gameBoard.putPiece(Pawn9);
			gameBoard.putPiece(Pawn10);
			gameBoard.putPiece(Pawn11);
			gameBoard.putPiece(Pawn12);
			gameBoard.putPiece(Pawn13);
			gameBoard.putPiece(Pawn14);
			gameBoard.putPiece(Pawn15);
			gameBoard.putPiece(Pawn16);

		} else {
			gameBoard = new Board("b");// ����b����Χ��
		}
	}

	/**
	 * ��ʼ��ѡ������
	 * 
	 * @param nameA ���A������
	 * @param nameB ���B������
	 */
	public void setNames(String nameA, String nameB) {
		this.getPlayerA().setPlayerName(nameA);
		this.getPlayerA().setPlayerTurn(0);
		this.getPlayerB().setPlayerName(nameB);
		this.getPlayerB().setPlayerTurn(1);
		gameBoard.playerA = nameA;
		gameBoard.playerB = nameB;
	}

	/**
	 * ���µ�����
	 * 
	 * @param player   ִ�е�ѡ��
	 * @param newPiece Ҫ���������
	 * @param P        ����λ��
	 * @return ����ֵ
	 */
	public boolean addnewPiece(Player player, Piece newPiece, Position P) {
		newPiece.setPosition(P.getPx(), P.getPy());
		return gameAction.putPiece(player, gameBoard, newPiece);
	}

	/**
	 * ��������
	 * 
	 * @param player ִ�е�ѡ��
	 * @param P      ������λ��
	 * @return ����ֵ
	 */
	public boolean removePiece(Player player, Position P) {
		return gameAction.removePiece(player, gameBoard, P);
	}

	/**
	 * @param p ����λ��
	 * @return ������λ��������ַ���
	 */
	public String checkPos(Position p) {
		return gameAction.checkPos(gameBoard, p);

	}

	/**
	 * @return ����˫�����Ӹ������ַ���
	 */
	public String countPiece() {
		return gameAction.countPiece(gameBoard);
	}

	/**
	 * �����ʷ
	 */
	public void printHistory() {
		gameAction.printHistory();
	}

	/**
	 * �ƶ�����
	 * 
	 * @param player ִ�в�����ѡ��
	 * @param p1     ��ʼλ��
	 * @param p2     ����λ��
	 * @return ����ֵ
	 */
	public boolean move(Player player, Position p1, Position p2) {
		return gameAction.move(player, gameBoard, p1, p2);
	}

	/**
	 * ����
	 * 
	 * @param player ִ�в�����ѡ��
	 * @param p1     ��ʼλ��
	 * @param p2     ����λ��
	 * @return ����ֵ
	 */
	public boolean eat(Player player, Position p1, Position p2) {
		return gameAction.eat(player, gameBoard, p1, p2);
	}

}
