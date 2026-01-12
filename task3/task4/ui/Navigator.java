package task4.ui;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Navigator {
    private Menu currentMenu;
    private final Deque<Menu> history = new ArrayDeque<>();

    public Navigator() {
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu menu) {
        this.currentMenu = menu;
    }

    public void printMenu() {
        if (currentMenu == null)
            return;
        System.out.println("\n--- " + currentMenu.getName() + " ---");
        List<MenuItem> items = currentMenu.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getTitle());
        }
        System.out.println("0. Back/Exit");
        System.out.print("Select: ");
    }

    public void navigate(int index) {
        if (currentMenu == null)
            return;
        List<MenuItem> items = currentMenu.getMenuItems();
        if (index < 1 || index > items.size()) {
            System.out.println("Invalid selection");
            return;
        }

        MenuItem item = items.get(index - 1);
        item.doAction();

        if (item.getNextMenu() != null) {
            history.push(currentMenu);
            currentMenu = item.getNextMenu();
        }
    }

    public boolean canGoBack() {
        return !history.isEmpty();
    }

    public void goBack() {
        if (!history.isEmpty())
            currentMenu = history.pop();
    }
}
