interface Tripsuliides{
	void alusta(char symbol); //lubatud 0 ja X
	char kelleKord();
	void paiguta(char symbol, int rida, int veerg) throws Exception;
	char kysi(int rida, int veerg);

	boolean kontrolliVoitu() throws Exception;
}
