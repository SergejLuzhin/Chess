public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) && correctPawnMove(line, column, toLine, toColumn);
    }

    private boolean correctPawnMove(int line, int column, int toLine, int toColumn){
        return ((color.equals("White") && line == 1 && column == toColumn && (line - toLine == -1 || line - toLine == -2)) ||
                (color.equals("White") && column == toColumn && line - toLine == -1) ||
                (color.equals("Black") && line == 6 && column == toColumn && (line - toLine == 1 || line - toLine == 2)) ||
                (color.equals("Black") && column == toColumn && line - toLine == 1));
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "P";
        else return "p";
    }
}
