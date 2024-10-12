public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) && correctQueenMove(line, column, toLine, toColumn);
    }

    private boolean correctQueenMove(int line, int column, int toLine, int toColumn){
        return (((Math.abs(line - toLine) == Math.abs(column - toColumn)) || (line == toLine && column != toColumn || column == toColumn && line != toLine)) && !(line == toLine && column == toColumn ));
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "Q";
        else return "q";
    }
}
