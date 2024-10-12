public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return super.movesInBoundaries(toLine, toColumn) &&
                correctHorseMove(line, column, toLine, toColumn) &&
                isMovingWithoutCollision(chessBoard, line, column, toLine, toColumn);
    }

    private boolean correctHorseMove(int line, int column, int toLine, int toColumn) {
        return ((Math.abs(line - toLine) == 2 && (Math.abs(column - toColumn) == 1)) ||
                (Math.abs(line - toLine) == 1 && (Math.abs(column - toColumn) == 2)));
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null){
            return true;
        }
        else{
            return !(chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor()));
        }
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
