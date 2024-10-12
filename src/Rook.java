public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) && correctRookMove(line, column, toLine, toColumn);
    }

    private boolean correctRookMove(int line, int column, int toLine, int toColumn){
        return ((column == toColumn && line != toLine) || (column != toColumn && line == toLine));
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "R";
        else return "r";
    }
}
