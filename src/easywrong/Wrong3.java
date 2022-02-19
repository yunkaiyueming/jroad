package easywrong;

class Result {
    int v;

    public boolean isValid() {
        return true;
    }
}

public class Wrong3 {
    static final Integer RESULT_CODE_OK = 0;
    static final Result RESULT_OK = new Result();

    public void printResult(Integer resultCode) {
        Result result = getResult(resultCode);

        // result可能为null，造成空指针异常
        if (result.isValid()) {
            print(result);
        }
    }

    public Result getResult(Integer resultCode) {
        // 即使resultCode为null，仍然可以正确执行，减少额外的判空语句
        if (RESULT_CODE_OK.equals(resultCode)) {
            return RESULT_OK;
        }
        return null;
    }

    public void print(Result result) {
    }
}