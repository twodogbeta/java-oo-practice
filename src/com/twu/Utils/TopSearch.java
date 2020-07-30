package com.twu.Utils;

import com.twu.Entity.TopTag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopSearch {
    private List<TopTag> topSearchList;

    public TopSearch() {
        topSearchList = new ArrayList();
    }

    public void addTopSearch(TopTag tag) {
        topSearchList.add(tag);
    }


    public void getTopSearchRank() {
        List<TopTag> newTags = topSearchList.stream().filter(cur -> cur.getPrice() == 0).sorted((a, b) -> b.getVotes() - a.getVotes()).collect(Collectors.toList());

        for (int i = 0; i < topSearchList.size(); i++) {
            if (topSearchList.get(i).getPrice() > 0) {
                newTags.add(i, topSearchList.get(i));
            }
        }

        for (int i = 0; i < newTags.size(); i++) {
            System.out.print(i + 1 + " ");
            System.out.println(newTags.get(i));
        }
    }

    public void votedToTopSearch(String name, int votedCount) {
        topSearchList.forEach(cur -> {
            if (cur.getName().equals(name)) {
                if (cur.isSuperTopSearch()) {
                    cur.setVotes(votedCount * 2);
                } else {
                    cur.setVotes(votedCount);
                }
            }
        });
    }

    public void successPaidTopSearch(String name, double paid, int rank) throws CloneNotSupportedException {
        for (int i = 0; i < topSearchList.size(); i++) {
            if (topSearchList.get(i).getName().equals(name)) {
                topSearchList.get(i).setPrice(paid);
                TopTag tag = (TopTag) topSearchList.get(i).clone();
                topSearchList.remove(i);
                topSearchList.remove(rank - 1);
                topSearchList.add(rank - 1, tag);
                break;
            }
        }
    }

    public double getTopSearchPrice(String TopSearchName) {
        return topSearchList.stream().filter(cur -> cur.getName().equals(TopSearchName)).collect(Collectors.toList()).get(0).getPrice();

    }
}