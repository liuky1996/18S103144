package P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyChessAndGoGame {

	public Game game;//ִ�в�����gameʵ��

	/**
	 * Χ��Ĳ˵�
	 */
	public void goGameMenu() {
		System.out.println("1.\t���ӣ�����δ�������ϵ�һ�����ӷ��������ϵ�ָ��λ�ã�");
		System.out.println("2.\t���ӣ��Ƴ��������ӣ�");
		System.out.println("3.\t��ѯĳ��λ�õ�ռ�����");
		System.out.println("4.\t������������������ϵ���������");
		System.out.println("5.\t����");
		System.out.println("end.\t ������Ϸ");
	}

	/**
	 * ��������˵�
	 */
	public void cheseGameMenu() {
		System.out.println("1.\t�ƶ������ϵ�ĳ��λ�õ��������µ�λ��");
		System.out.println("2.\t���ӣ�ʹ�ü������ӳԵ��������ӣ�");
		System.out.println("3.\t��ѯĳ��λ�õ�ռ�����");
		System.out.println("4.\t����������ҷֱ��������ϵ���������");
		System.out.println("5.\t����");
		System.out.println("end.\t ������Ϸ");
	}

	/**
	 * ��Ϸ��δ��ȷ����ʱ�Ŀͻ��˺���
	 */
	public void gameMain() {
		String gameType;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("������Ϸ����:");
				System.out.println("a:��������   b:Χ��");
				gameType = reader.readLine().trim();
				if (gameType.equals("a") || gameType.equals("b")) {
					game = new Game(gameType);
					break;
				}
			}
			System.out.println("������ѡ��A������");
			String playerAName = reader.readLine().trim();
			System.out.println("������ѡ��B������");
			String playerBName = reader.readLine().trim();
			game.setNames(playerAName, playerBName);
			if (gameType.equals("a")) {
				System.out.println("����������Ϸ��ʼ!");
				cheseGame();
			} else if (gameType.equals("b")) {
				System.out.println("Χ����Ϸ��ʼ!");
				goGame();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MyChessAndGoGame().gameMain();
	}

	/**
	 * ִ��Χ�����
	 * 
	 * @throws IOException
	 */
	public void goGame() throws IOException {
		String inputString;
		String[] colorStrings = new String[2];
		colorStrings[0] = "white";
		colorStrings[1] = "black";
		BufferedReader reader = null;
		String[] arguments;
		int TURN = 0;// ����˳�����
		boolean exitflag = false;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println();
				System.out.println("it's " + game.getPlayer(TURN).getPlayerName() + "'s turn!");
				goGameMenu();
				String input = reader.readLine().trim();
				switch (input) {
				case "1":// ����δ�������ϵ�һ�����ӷ��������ϵ�ָ��λ��
					System.out.println("����ѡ��" + game.getPlayer(TURN).getPlayerName() + "��ִ�ף�����������x y�����Կո������");
					inputString = reader.readLine().trim();
					arguments = inputString.split("\\s");
					if (arguments.length == 2) {
						Piece newPiece = new Piece(colorStrings[TURN], TURN);
						Position P = new Position(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));
						if (game.addnewPiece(game.getPlayer(TURN), newPiece, P)) {
							TURN = (TURN + 1) % 2;
							System.out.println("Done");
						} else {
							continue;
						}
					} else {
						System.out.println("���������Ϊ2��");
					}
					break;
				case "2":// ���ӣ��Ƴ��������ӣ�
					System.out.println("��������λ������x��y�����Կո������");
					inputString = reader.readLine().trim();
					arguments = inputString.split("\\s");
					if (arguments.length == 2) {
						Position P = new Position(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));
						if (game.removePiece(game.getPlayer(TURN), P)) {
							TURN = (TURN + 1) % 2;
							System.out.println("Done");
						} else {
							continue;
						}
					} else {
						System.out.println("���������Ϊ2��");
					}
					break;
				case "3":// ��ѯռ�����
					System.out.println("��������λ������x��y�����Կո������");
					inputString = reader.readLine().trim();
					arguments = inputString.split("\\s");
					if (arguments.length == 2) {
						Position P = new Position(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));
						System.out.println(game.checkPos(P));
					}
					break;
				case "4":// ������������������ϵ���������
					System.out.println(game.countPiece());
					break;
				case "5":// ������������������ϵ���������
					System.out.println("�������");
					TURN = (TURN + 1) % 2;
					break;
				case "end":// ������Ϸ
					System.out.println("The game is over.");
					exitflag = true;
					break;
				default:
					System.out.println("�������");
					break;
				}
				if (exitflag)
					break;
			}
			System.out.println("�Ƿ�鿴������ʷ��(����y��n)");
			switch (reader.readLine().trim()) {
			case "y":
				game.printHistory();
				break;
			case "n":
				break;
			}
			System.out.println("����������������Ϸ��������������");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ִ�й�������ĺ���
	 * 
	 * @throws IOException
	 */
	public void cheseGame() throws IOException {
		String inputString;
		BufferedReader reader = null;
		String[] arguments;
		int TURN = 0;// ����˳�����
		boolean exitflag = false;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println();
				System.out.println("it's " + game.getPlayer(TURN).getPlayerName() + "'s turn!");
				cheseGameMenu();
				String input = reader.readLine().trim();
				switch (input) {
				case "1": // �ƶ������ϵ�ĳ��λ�õ��������µ�λ��
					System.out.println("����ѡ��" + game.getPlayer(TURN).getPlayerName() + "������������x1 y1 ������x2 y2�����Կո������");
					inputString = reader.readLine().trim();
					arguments = inputString.split("\\s");
					if (arguments.length == 4) {
						Position P1 = new Position(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));
						Position P2 = new Position(Integer.valueOf(arguments[2]), Integer.valueOf(arguments[3]));
						if (game.move(game.getPlayer(TURN), P1, P2)) {
							TURN = (TURN + 1) % 2;
							System.out.println("Done");
						}
					} else {
						System.out.println("���������Ϊ4��");
					}
					break;
				case "2":// ���ӣ�ʹ�ü������ӳԵ��������ӣ�
					System.out.println("����ѡ��" + game.getPlayer(TURN).getPlayerName() + "������������x1 y1 ������x2 y2�����Կո������");
					inputString = reader.readLine().trim();
					arguments = inputString.split("\\s");
					if (arguments.length == 4) {
						Position P1 = new Position(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));
						Position P2 = new Position(Integer.valueOf(arguments[2]), Integer.valueOf(arguments[3]));
						if (game.eat(game.getPlayer(TURN), P1, P2)) {
							TURN = (TURN + 1) % 2;
							System.out.println("Done");
						}
					} else {
						System.out.println("���������Ϊ4��");
					}
					break;
				case "3":// ��ѯռ�����
					System.out.println("��������λ������x��y�����Կո������");
					inputString = reader.readLine().trim();
					arguments = inputString.split("\\s");
					if (arguments.length == 2) {
						Position P = new Position(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));

						System.out.println(game.checkPos(P));
					}
					break;
				case "4":// ������������������ϵ���������
					System.out.println(game.countPiece());
					break;
				case "5":// ������������������ϵ���������
					System.out.println("�������");
					TURN = (TURN + 1) % 2;
					break;
				case "end":// ������Ϸ
					System.out.println("The game is over.");
					exitflag = true;
					break;
				default:
					System.out.println("�������");
					break;
				}
				if (exitflag)
					break;
			}
			System.out.println("�Ƿ�鿴������ʷ��(����y��n)");
			switch (reader.readLine().trim()) {
			case "y":
				game.printHistory();
				break;
			case "n":
				break;
			}
			System.out.println("����������������Ϸ��������������");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
