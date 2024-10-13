public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) &&
                correctKingMove(line, column, toLine, toColumn) &&
                isMovingWithoutCollision(chessBoard, line, column, toLine, toColumn);
    }

    private boolean correctKingMove(int line, int column, int toLine, int toColumn){
        return (!(line == toLine && column == toColumn) && (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1));
    }

    //TO DO
    public boolean isUnderAttack(ChessBoard chessBoard, String color, int line, int column){
        return isUnderAttackByPawn(chessBoard, color, line, column) ||
                isUnderAttackByHorse(chessBoard, color, line, column) ||
                isUnderAttackByBishop(chessBoard, color, line, column) ||
                isUnderAttackByRook(chessBoard, color, line, column);        //queen processed through bishop and rook
    }

    private boolean isUnderAttackByPawn(ChessBoard chessBoard, String color, int line, int column){
        for (int i = line - 1; i <= line + 1; i += 2){
            for (int j = column - 1; j <= column + 1; j += 2){
                if(chessBoard.checkPos(i) && chessBoard.checkPos(j)){
                    if(chessBoard.board[i][j] != null) {
                        if (!color.equals(chessBoard.board[i][j].getColor()) && chessBoard.board[i][j].getSymbol().equalsIgnoreCase("p")) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isUnderAttackByHorse(ChessBoard chessBoard, String color, int line, int column){
        int [][] possiblePositions = {
                {line+2, column+1},
                {line+1, column+2},
                {line-1, column+2},
                {line-2, column+1},
                {line-2, column-1},
                {line-1, column-2},
                {line+1, column-2},
                {line+2, column-1}
        };
        for (int i = 0; i < possiblePositions.length; i++){
                if(chessBoard.checkPos(possiblePositions[i][0]) && chessBoard.checkPos(possiblePositions[i][1])){
                    if(chessBoard.board[possiblePositions[i][0]][possiblePositions[i][1]] != null) {
                        if (!color.equals(chessBoard.board[possiblePositions[i][0]][possiblePositions[i][1]].getColor()) && chessBoard.board[possiblePositions[i][0]][possiblePositions[i][1]].getSymbol().equalsIgnoreCase("h")) return true;
                    }
                }
        }
        return false;
    }

    private boolean isUnderAttackByBishop(ChessBoard chessBoard, String color, int line, int column){
        //up left
        int currentLine = line + 1;
        int currentColumn = column - 1;
        while (currentLine <= 7 && currentColumn >= 0){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentLine++;
            currentColumn--;
        }
        //up right
        currentLine = line + 1;
        currentColumn = column + 1;
        while (currentLine <= 7 && currentColumn <= 7){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentLine++;
            currentColumn++;
        }
        //down right
        currentLine = line - 1;
        currentColumn = column + 1;
        while (currentLine >= 0 && currentColumn <= 7){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentLine--;
            currentColumn++;
        }
        //down left
        currentLine = line - 1;
        currentColumn = column - 1;
        while (currentLine >= 0 && currentColumn >= 0){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentLine--;
            currentColumn--;
        }
        return false;
    }

    private boolean isUnderAttackByRook(ChessBoard chessBoard, String color, int line, int column){
        //up
        int currentLine = line + 1;
        int currentColumn = column;
        while (currentLine <= 7){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentLine++;
        }
        //right
        currentLine = line;
        currentColumn = column + 1;
        while (currentColumn <= 7){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentColumn++;
        }
        //down
        currentLine = line - 1;
        currentColumn = column;
        while (currentLine >= 0){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentLine--;
        }
        //left
        currentLine = line;
        currentColumn = column - 1;
        while (currentColumn >= 0){
            if(chessBoard.board[currentLine][currentColumn] != null){
                if(!chessBoard.board[currentLine][currentColumn].getColor().equals(color) &&
                        ((chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("b")) ||
                        (chessBoard.board[currentLine][currentColumn].getSymbol().equalsIgnoreCase("q"))))
                {
                    return true;
                }
                else break;
            }
            currentColumn--;
        }
        return false;
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) return true;
        else {
            return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
        }
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "K";
        else return "k";
    }
}
