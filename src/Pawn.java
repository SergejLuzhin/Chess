public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) &&
                correctPawnMove(line, column, toLine, toColumn) &&
                isMovingWithoutCollision(chessBoard, line, column, toLine, toColumn);
    }

    private boolean correctPawnMove(int line, int column, int toLine, int toColumn) {
        return ((color.equals("White") && line == 1 && column == toColumn && (line - toLine == -1 || line - toLine == -2)) ||
                (color.equals("White") && column == toColumn && line - toLine == -1) ||
                (color.equals("Black") && line == 6 && column == toColumn && (line - toLine == 1 || line - toLine == 2)) ||
                (color.equals("Black") && column == toColumn && line - toLine == 1));
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(line - toLine) == 2) {
            if (chessBoard.board[(line + toLine) / 2][column] == null && chessBoard.board[toLine][toColumn] == null) {
                return true;
            } else if (chessBoard.board[(line + toLine) / 2][column] == null) {
                return !(chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor()));
            }
        } else if ((Math.abs(line - toLine) == 1)) {
            if (chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "P";
        else return "p";
    }
}
