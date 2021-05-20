package com.example.web;

import com.example.model.League;
import com.example.model.MatchInformation;
import com.example.model.Team;
import com.example.repository.LeagueRepository;
import com.example.service.MatchInformationService;
import com.example.service.TeamService;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import com.example.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Controller
/*@RestController*/
/*@RequestMapping("league")*/
public class LeagueController {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private MatchInformationService matchInformationService;

    /**
     * 从数据库中获取联赛列表
     *
     * @return
     */
    public List<League> leagueList() {
        List<League> leagues = new ArrayList<>();
        for (League league : leagueService.leagueList()) {
            leagues.add(league);
        }
        return leagues;
    }

    /**
     * 跳转至添加联赛信息页面
     *
     * @param model
     * @return
     */
    @GetMapping("/league")
    public ModelAndView toAddPage(Model model) {
        model.addAttribute("league", new League());
        return new ModelAndView("league/addLeagueInformation", "leagueModel", model);
    }

    /**
     * 添加联赛，跳转至添加赛制详情页面
     *
     * @param league
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/league")
    public String addLeagueInformation(League league, Model model, HttpSession session) {
        leagueRepository.save(league);
        int league_id = league.getLeague_id();
        League league1 = league;
        System.out.println(league_id);
        /*League league2=leagueRepository.getOne(league_id);*/
        League league2 = leagueService.getLeaugeById(league_id);
        model.addAttribute("league", league2);
        session.setAttribute("league1", league.getLeague_id());
        /*return "/leagueDetail";*/
        return "redirect:/leagues";
        /*return "redirect:/leagueDetail";*/
    }

    /**
     * 跳转至查询赛事信息页面
     *
     * @param model
     * @return
     */
    @GetMapping("/queryLeague")
    public ModelAndView toQueryPage(Model model) {
        model.addAttribute("league", new League());
        return new ModelAndView("league/queryLeague", "leagueModel", model);
    }

    /**
     * 通过联赛 id 查询联赛
     *
     * @param league1
     * @param model
     * @return
     */
    @PostMapping("/showLeagueById")
    public String findById(League league1, Model model) {
        //int league_id=Integer.parseInt(request.getParameter("league_id"));
        int league_id = league1.getLeague_id();
        System.out.println(league_id);
        /*League league2=leagueRepository.getOne(league_id);*/
        League league2 = leagueService.getLeaugeById(league_id);
        model.addAttribute("league", league2);
        return "league/showLeague";
    }

    /**
     * 通过联赛名称查询联赛
     *
     * @param league1
     * @param model
     * @return
     */
    @PostMapping("/showLeagueByName")
    public String findByName(League league1, Model model) {
        String leagueName = league1.getLeagueName();
        System.out.println(leagueName);
        /*League league2=leagueRepository.findByLeagueName(leagueName);*/
        Collection<League> leagueCollection = leagueService.getLeagueByNameLike(leagueName);
        model.addAttribute("league", leagueCollection);
        /*League league2=leagueService.getLeagueByName(leagueName);
        model.addAttribute("league",league2);*/
        return "league/showLeague";
    }

    /**
     * 通过联赛简称查询联赛
     *
     * @param league1
     * @param model
     * @return
     */
    @PostMapping("/showLeagueByShorterName")
    public String findByShorterName(League league1, Model model) {
        String shorterName = league1.getShorterName();
        System.out.println(shorterName);
        /*League league2=leagueRepository.findByShorterName(shorterName);*/
        Collection<League> leagueCollection = leagueService.getLeagueByShorterNameLike(shorterName);
        model.addAttribute("league", leagueCollection);
        /*League league2=leagueService.getLeagueByShorterName(shorterName);
        model.addAttribute("league",league2);*/
        return "league/showLeague";
    }

    /**
     * 通过开始日期查询
     *
     * @param league1
     * @param model
     * @return
     */
    @PostMapping("/showLeagueByDate")
    public String findByDate(League league1, Model model) {
        String startDate = league1.getStartDate();
        System.out.println(startDate);
        /*Collection<League> leagueCollection=leagueRepository.findByStartDate(startDate);*/
        Collection<League> leagueCollection = leagueService.getLeagueByStartDate(startDate);
        model.addAttribute("league", leagueCollection);
        return "league/showLeague";
    }

    /**
     * 通过主办方查询联赛
     *
     * @param league
     * @param model
     * @return
     */
    @PostMapping("/showLeagueBySponsor")
    public String findBySponsor(League league, Model model) {
        String sponsor = league.getSponsor();
        System.out.println(sponsor);
        /*Collection<League> leagueCollection=leagueRepository.findBySponsor(sponsor);*/
        Collection<League> leagueCollection = leagueService.getLeagueBySponsorLike(sponsor);
        model.addAttribute("league", leagueCollection);
        /*Collection<League> leagueCollection=leagueService.getLeagueBySponsor(sponsor);
        model.addAttribute("league",leagueCollection);*/
        return "league/showLeague";
    }

    /**
     * 通过多条件查询联赛
     *
     * @param league
     * @param model
     * @return
     */
    @PostMapping("/showLeagueByComplex")
    public String findByComplex(League league, Model model) {
        String leagueName = league.getLeagueName();
        String startDate = league.getStartDate();
        System.out.println("联赛名称：" + leagueName + "，开始日期：" + startDate);
        Collection<League> leagueCollection = leagueRepository.findByLeagueNameContainingAndStartDate(leagueName, startDate);
        model.addAttribute("league", leagueCollection);
        return "league/showLeague";
    }

    /**
     * 点击"查看"按钮查看联赛详细信息
     *
     * @param league_id
     * @param model
     * @return
     */
    @GetMapping("/showLeagueDetails")
    public String showLeagueDetails(int league_id, Model model) {
        /*League league=leagueRepository.getOne(league_id);*/
        League league = leagueService.getLeaugeById(league_id);
        System.out.println(league_id);
        model.addAttribute("league", league);
        return "league/showLeagueDetails";
    }

    /**
     * 点击"修改"按钮跳转至修改联赛信息页面
     *
     * @param league_id
     * @param model
     * @return
     */
    @GetMapping("/modifyLeague")
    public String toModifyPage(int league_id, Model model) {
        /*League league=leagueRepository.getOne(league_id);*/
        League league = leagueService.getLeaugeById(league_id);
        System.out.println(league_id);
        model.addAttribute("league", league);
        return "league/modifyLeague";
    }

    /**
     * 修改联赛信息
     *
     * @param league
     * @return
     */
    @PostMapping("/modifyLeague")
    public String modifyLeague(League league) {
        /*leagueRepository.save(league);*/
        leagueService.saveLeague(league);
        return "redirect:/leagues";
    }

    /**
     * 点击"删除"按钮删除联赛信息
     *
     * @param league_id
     * @return
     */
    @RequestMapping("/deleteLeague")
    public String deleteLeague(int league_id) {
        /*leagueRepository.deleteById(league_id);*/
        leagueService.deleteLeague(league_id);
        return "redirect:/leagues";
    }

    /**
     * 跳转至自动生成赛程页面
     *
     * @param model
     * @return
     */
    @GetMapping("/autoMatch")
    public ModelAndView toAutoMatchPage(Model model) {
        model.addAttribute("leagueList", leagueList());
        return new ModelAndView("league/autoMatch", "leagueModel", model);
    }

    /**
     * 查看参加该联赛的所有球队
     *
     * @param league_id
     * @param model
     * @return
     */
    @GetMapping("/showTeamsInLeague")
    public String showTeamsInLeague(int league_id, Model model) {
        /*League league=leagueRepository.getOne(league_id);*/
        League league = leagueService.getLeaugeById(league_id);
        System.out.println(league_id);
        String leagueName = league.getLeagueName();
        System.out.println(leagueName);
        model.addAttribute("league", league);

        List<Team> teams = teamService.getTeamByLeague(leagueName);
        model.addAttribute("teams", teams);

        return "league/showTeamsInLeague";
    }

    /**
     * 跳转至自动生成赛程结果页面
     *
     * @param league_id
     * @param model
     * @return
     */
    @GetMapping("/autoMatchResult")
    public String autoMatchResult(int league_id, Model model) {
        League league = leagueService.getLeaugeById(league_id);
        String leagueName = league.getLeagueName();
        model.addAttribute("league", league);
        List<Team> teams = teamService.getTeamByLeague(leagueName);
        model.addAttribute("teams", teams);

        // 判断该联赛是否已经有比赛赛程，如果有，则不能自动分配赛程
        if (matchInformationService.getMatchInformationByLeague(leagueName).size() > 0) {
            System.out.println("已有赛程，不能自动添加赛程！");
            List<MatchInformation> matchInformations = matchInformationService.getMatchInformationByLeague(leagueName);
            model.addAttribute("matchInformations", matchInformations);
            return "league/autoMatchResult";
        } else {
            LinkedList<String> list = new LinkedList<String>();
            for (int i = 0; i < teams.size(); i++) {
                Team team = teams.get(i);
                System.out.println("球队名称：" + team.getTeamName());
                list.add(team.getTeamName());
            }

            /*for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }*/

            MatchInformation matchInformation = new MatchInformation();

            // 要将主队、客队、比赛轮次、所属于联赛存储进数据库中
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.println("第" + (i + 1) + "轮的赛程：");

                matchInformation.setLeague(leagueName);

                // 轮次
                int round = i + 1;
                String roundStr = "第" + round + "轮";
                /*System.out.println(roundStr);*/
                matchInformation.setRound(roundStr);

                for (int j = 0; j < list.size() / 2; j++) {
                    // 生成从1到100的整型随机数
                    int randomNumber = (int) (1 + Math.random() * (100));
                    /*System.out.println("随机数为："+randomNumber);*/
                    if (randomNumber % 2 == 0) {
                        // 客队
                        String guestTeam = list.get(j);
                        matchInformation.setGuestTeam(guestTeam);
                        /*System.out.println("客队："+guestTeam);*/
                        // 主队
                        String homeTeam = list.get(list.size() - 1 - j);
                        matchInformation.setHomeTeam(homeTeam);
                        /*System.out.println("主队："+homeTeam);*/

                        matchInformationService.saveMatchInformation(matchInformation);

                        System.out.println(guestTeam + "(客队) VS " + homeTeam + "(主队)");
                        /*System.out.println(list.get(j)+" VS "+list.get(list.size()-1-j));*/


                    } else {
                        // 客队
                        String guestTeam = list.get(list.size() - 1 - j);
                        matchInformation.setGuestTeam(guestTeam);
                        /*System.out.println("客队："+guestTeam);*/
                        // 主队
                        String homeTeam = list.get(j);
                        matchInformation.setHomeTeam(homeTeam);
                        /*System.out.println("主队："+homeTeam);*/

                        matchInformationService.saveMatchInformation(matchInformation);

                        System.out.println(guestTeam + "(客队) VS " + homeTeam + "(主队)");
                        /*System.out.println(list.get(list.size()-1-j)+" VS "+list.get(j));*/
                    }
                }
                // 获取最后一个元素
                String temp = list.pollLast();
                list.add(1, temp);
            }

            List<MatchInformation> matchInformations = matchInformationService.getMatchInformationByLeague(leagueName);
            model.addAttribute("matchInformations", matchInformations);

            return "league/autoMatchResult";
        }


    }

    // 球队单循环
    /*public static void change(int[] a) {
        int temp=a[a.length-1];
        for(int i=a.length-1;i>=1;i--) {
            a[i]=a[i-1];
        }
        a[1]=temp;
    }*/

    /**
     * 跳转至赛事信息页面(查询所有联赛)
     *
     * @param model
     * @return
     */
    @GetMapping("/leagues")
    public ModelAndView toLeaguesPage(Model model) {
        model.addAttribute("leagueList", leagueList());
        return new ModelAndView("league/leagues", "leagueModel", model);
    }

    /**
     * 跳转至所有联赛相册信息页面
     *
     * @param model
     * @return
     */
    @GetMapping("/albums")
    public ModelAndView toAllAlbumsPage(Model model) {
        model.addAttribute("leagueList", leagueList());
        return new ModelAndView("album/albums", "leagueModel", model);
    }
}
