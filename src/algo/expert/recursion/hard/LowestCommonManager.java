package algo.expert.recursion.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given three inputs, all instances of OrgCHart
 * 1. TopManager in an organizational chart representing complete organizational hierarchy
 * 2. Two other distinct reportee in the organization
 * Write a function to give the lowest common manager of two reportee.
 */

public class LowestCommonManager {
    static class OrgInfo{
        OrgChart lcm;
        int noOfReportFound;
    }

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return findReport(topManager, reportOne, reportTwo).lcm;
    }

    //O(n) time | O(d) space n is no of people and d is depth
    public static OrgInfo findReport(OrgChart root, OrgChart reportOne, OrgChart reportTwo){
        OrgInfo info  = new OrgInfo();
        if(root!=null){
            int noOfReportFound = 0;
            if(root==reportOne || root==reportTwo) noOfReportFound++;
            for(OrgChart org: root.directReports){
                OrgInfo oInfo = findReport(org, reportOne, reportTwo);
                if(oInfo.lcm!=null){
                    return oInfo;
                }
                noOfReportFound += oInfo.noOfReportFound;
            }
            info.noOfReportFound=noOfReportFound;
            if(noOfReportFound==2){
                info.lcm=root;
            }

        }
       return info;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    public static void main(String[] args) {
        var orgCharts = getOrgCharts();
        orgCharts
                .get('A')
                .addDirectReports(new OrgChart[] {orgCharts.get('B'), orgCharts.get('C')});
        orgCharts
                .get('B')
                .addDirectReports(new OrgChart[] {orgCharts.get('D'), orgCharts.get('E')});
        orgCharts
                .get('C')
                .addDirectReports(new OrgChart[] {orgCharts.get('F'), orgCharts.get('G')});
        orgCharts
                .get('D')
                .addDirectReports(new OrgChart[] {orgCharts.get('H'), orgCharts.get('I')});
        System.out.println(getLowestCommonManager(orgCharts.get('A'), orgCharts.get('E'), orgCharts.get('B')).name);

    }

    public static HashMap<Character, OrgChart> getOrgCharts() {
        var orgCharts = new HashMap<Character, OrgChart>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            orgCharts.put(a, new OrgChart(a));
        }
        orgCharts.get('X').addDirectReports(new OrgChart[] {orgCharts.get('Z')});
        return orgCharts;
    }


}
