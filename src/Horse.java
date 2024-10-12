public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return super.movesInBoundaries(toLine, toColumn) && correctHorseMove(line, column, toLine, toColumn);
    }

    private boolean correctHorseMove(int line, int column, int toLine, int toColumn) {
        return ((Math.abs(line - toLine) == 2 && (Math.abs(column - toColumn) == 1)) ||
                (Math.abs(line - toLine) == 1 && (Math.abs(column - toColumn) == 2)));
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "H";
        else return "h";
    }

    @Override
    public String getColor() {
        return super.getColor();
    }
}
