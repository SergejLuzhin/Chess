public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) && correctBishopMove(line, column, toLine, toColumn);
    }

    private boolean correctBishopMove(int line, int column, int toLine, int toColumn){
        return ((Math.abs(line - toLine) == Math.abs(column - toColumn)) && !(line == toLine || column == toColumn));
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "B";
        else return "b";
    }
}
