package com.learn.tuling.designpattern.chainofresponsibility;

/**
 * 责任链
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(false).loggedOn(false).build();
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        if (requestFrequentHandler.process(request)) {
            System.out.println("正常业务处理");
        } else {
            System.out.println("访问异常");
        }
    }
}

class Request {

    private boolean loggedOn;
    private boolean frequentOk;

    public Request(boolean loggedOn, boolean frequentOk) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        this.loggedOn = loggedOn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public void setFrequentOk(boolean frequentOk) {
        this.frequentOk = frequentOk;
    }


    static class RequestBuilder {

        private boolean loggedOn;
        private boolean frequentOk;

        public RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }

        public RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        public Request build() {
            return new Request(this.loggedOn, this.frequentOk);
        }

    }

}

abstract class Handler {

    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}


class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("访问频率控制");

        if (request.isFrequentOk()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }

            return next.process(request);

        }

        return false;
    }
}

class LoggingHandler extends Handler {

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("登录验证");

        if (request.isLoggedOn()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }

            return next.process(request);
        }

        return false;
    }
}