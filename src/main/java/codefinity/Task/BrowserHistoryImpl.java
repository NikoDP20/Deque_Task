package codefinity.Task;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistoryImpl implements BrowserHistory {

    private final Deque<String> backStack = new ArrayDeque<>();
    private final Deque<String> forwardStack = new ArrayDeque<>();
    private String currentPage;

    public BrowserHistoryImpl(Deque<String> backStack, Deque<String> forwardStack, String initialUrl) {
        this.backStack.addAll(backStack);
        this.forwardStack.addAll(forwardStack);
        this.currentPage = initialUrl;
    }

    @Override
    public String getCurrentPage() {
        return currentPage;
    }

    @Override
    public void goForward() {
        if (!forwardStack.isEmpty()){
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        }
    }

    @Override
    public void goBack() {
        if (!backStack.isEmpty()){
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        }
    }

    @Override
    public void visitPage(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = url;
        forwardStack.clear();
    }
}
