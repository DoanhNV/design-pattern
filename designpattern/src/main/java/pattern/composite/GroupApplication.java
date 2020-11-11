package pattern.composite;

import pattern.composite.model.Group;

public class GroupApplication {

    public static void payment(double money, Group group) {
        group.payDown(money);
    }
}
