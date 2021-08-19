package ee.food.crnk;

import ee.food.crnk.resources.*;
import hu.webarticum.treeprinter.ListingTreePrinter;
import hu.webarticum.treeprinter.SimpleTreeNode;
import lombok.val;

public class Utils {

    static void printMenu(Menu activeMenu) {
        val rootNode = new SimpleTreeNode("Menu");

        for (MenuGroup mg : activeMenu.getMenuGroups()) {

            val menuGroupNode = new SimpleTreeNode(String.format("Mg(%d) %s", mg.getId(), mg.getName()));
            rootNode.addChild(menuGroupNode);

            for (MenuItem mi : mg.getMenuItems()) {
                val menuItemNode = new SimpleTreeNode(String.format("Mi(%d) %s price: %s", mi.getId(), mi.getName(), mi.getClientPrice()));
                menuGroupNode.addChild(menuItemNode);
                val dietaryTagsNode = new SimpleTreeNode("Dietary Tags");
                menuItemNode.addChild(dietaryTagsNode);

                for (DietaryTag dietaryTag : mi.getDietaryTags()) {
                    dietaryTagsNode.addChild(new SimpleTreeNode(dietaryTag.getName()));
                }

                val optionsNode = new SimpleTreeNode("Options");
                menuItemNode.addChild(optionsNode);

                for (MenuOptionGroup mog : mi.getMenuOptionGroups()) {
                    val menuOptionGroupNode = new SimpleTreeNode(String.format("Mog(%d) %s %s", mog.getId(), mog.getVerb(), mog.getName()));
                    optionsNode.addChild(menuOptionGroupNode);

                    for (MenuOptionItem moi : mog.getMenuOptionItems()) {
                        val menuOptionItem = new SimpleTreeNode(String.format("Moi(%d) %s%n  price: %s", moi.getId(), moi.getName(), moi.getClientPrice()));
                        menuOptionGroupNode.addChild(menuOptionItem);

                        val moiDietaryTagsNode = new SimpleTreeNode("Dietary Tags");
                        menuOptionItem.addChild(moiDietaryTagsNode);

                        for (DietaryTag dietaryTag : mi.getDietaryTags()) {
                            moiDietaryTagsNode.addChild(new SimpleTreeNode(dietaryTag.getName()));
                        }
                    }
                }
            }
        }

        new ListingTreePrinter().print(rootNode);
    }
}
