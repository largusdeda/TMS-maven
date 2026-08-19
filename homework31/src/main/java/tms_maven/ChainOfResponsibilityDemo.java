package tms_maven;

abstract class SupportHandler {
    protected SupportHandler next;

    public void setNext(SupportHandler handler) {
        next = handler;
    }

    public abstract void handleRequest(String issue, int severity);
}

class BasicSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 1) {
            System.out.println("Базовая поддержка решает: " + issue);
        } else if (next != null) {
            next.handleRequest(issue, severity);
        }
    }
}

class ExpertSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 3) {
            System.out.println("Экспертная поддержка решает: " + issue);
        } else if (next != null) {
            next.handleRequest(issue, severity);
        }
    }
}

class ManagerSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 5) {
            System.out.println("Менеджер решает: " + issue);
        } else {
            System.out.println("Проблема \"" + issue + "\" требует руководства");
        }
    }
}

public class ChainOfResponsibilityDemo {
    public static void main() {
        SupportHandler basic = new BasicSupport();
        SupportHandler expert = new ExpertSupport();
        SupportHandler manager = new ManagerSupport();

        basic.setNext(expert);
        expert.setNext(manager);

        basic.handleRequest("Что-то нажал и всё сломалось", 1);
        basic.handleRequest("Проблемы с сетью", 2);
        basic.handleRequest("Какая-то очередная проблема", 4);
        basic.handleRequest("Бебебе с бабаба", 6);
    }
}
