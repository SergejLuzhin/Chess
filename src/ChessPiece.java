public abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard,
                                              int line, int column,
                                              int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean movesInBoundaries(int toLine, int toColumn) {
        return toLine <= 7 && toLine >= 0 && toColumn <= 7 && toColumn >= 0;
    }

    public abstract boolean isMovingWithoutCollision(ChessBoard chessBoard,
                                                     int line, int column,
                                                     int toLine, int toColumn);


}
