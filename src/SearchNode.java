import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchNode {
    private String subreddit;
    private List<String> mainPageRegexs;
    private HashMap<String, List<String>> subPageRegexs;

    public SearchNode(String subreddit){
        this.subreddit = subreddit;
        mainPageRegexs = new ArrayList<>();
    }

    public void addMainPageRegex(String regex){
        mainPageRegexs.add(regex);
        subPageRegexs.put(regex, new ArrayList<>());
    }

    public void removeMainPageRegex(String regex){
        int i = 0;
        for(; i < mainPageRegexs.size(); i++)
        {
            if(mainPageRegexs.get(i).equals(regex)){
                mainPageRegexs.remove(i);
            }
        }
    }

    public void addSubPageRegex(String mainPageRegex, String subPageRegex){
        if(subPageRegexs.containsKey(mainPageRegex)){
            subPageRegexs.get(mainPageRegex).add(subPageRegex);
        }
    }

    public void removeSubPageRegex(String mainPageRegex, String subPageRegex){
        if(subPageRegexs.containsKey(mainPageRegex)){
            int i = 0;
            for(; i < subPageRegexs.get(mainPageRegex).size(); i++){
                if(subPageRegexs.get(mainPageRegex).get(i).equals(subPageRegex)){
                    subPageRegexs.get(mainPageRegex).remove(i);
                }
            }
        }
    }

    public String[] getMainPageRegexs(){
        return (String[])mainPageRegexs.toArray();
    }

    public String getSubreddit(){
        return subreddit;
    }

    public String[] getSubPageRegexs(String mainPageRegex) throws ClassNotFoundException{
        if(subPageRegexs.containsKey(mainPageRegex)){
            return (String[])subPageRegexs.get(mainPageRegex).toArray();
        } else {
            throw new ClassNotFoundException("name not contained in regex!\n");
        }
    }
}
