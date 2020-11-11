package pattern.composite.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Group {

    private List<Group> childGroups;
    private List<Person> members;
    private double totalMoney;

    public void payDown(double money) {
        if (childGroups == null && members == null) {
            throw new RuntimeException("This group has no child group or member!");
        }

        holdMoney(money);
        if (childGroups != null) {
            payGroups();
        } else {
            payMembers();
        }
    }

    private void holdMoney(double money) {
        this.totalMoney = money;
    }

    private void payGroups () {
        double moneyPerGroup = totalMoney / childGroups.size();
        childGroups.forEach(childGroup -> childGroup.payDown(moneyPerGroup));
    }

    private void payMembers () {
        double moneyPerMember = totalMoney / members.size();
        members.forEach(member -> member.retrieve(moneyPerMember));
    }
}
