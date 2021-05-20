package com.example.web;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
/*@RequestMapping("/user")*/
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 从数据库中获取用户列表
     *
     * @return
     */
    private List<User> userList() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    /**
     * 查询所用用户
     *
     * @return
     */
    @GetMapping("/users")
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userList());
        return new ModelAndView("login.html", "userModel", model);
    }

    /**
     * 跳转至注册页面
     *
     * @param model
     * @return
     */
    @GetMapping("/register")
    public ModelAndView toRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("register", "userModel", model);
    }

    /**
     * 添加用户
     *
     * @param user1
     * @param map
     * @return
     */
    @PostMapping("/register")
    public String register(User user1, Map<String, Object> map) {
        String account = user1.getAccount();
        System.out.println(account);

        // 查询数据库中是否已存在相同的账号
        for (User user : userRepository.findAll()) {
            if (account.equals(user.getAccount())) {
                //用户名已存在
                map.put("msg", "用户名已存在");
                System.out.println("用户名已存在");
                return "register";
            }
        }
        userRepository.save(user1);
        return "login";
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @PostMapping("/modifyUser")
    public String modifyUser(User user) {
        userRepository.save(user);
        return "login";
    }

    /**
     * 查询
     * 根据id查询
     *
     * @param user_id
     * @return
     */
    /*@GetMapping(value = "/users/{user_id}")
    public User findUserById(@PathVariable("user_id") int user_id) {
        return userRepository.getOne(user_id);
    }*/

    /**
     * 查询
     * 通过账号查询
     *
     * @param account
     * @return
     */
    /*@GetMapping(value = "/users/account/{account}")
    public User findUserByAccount(@PathVariable("account") String account) {
        return userRepository.findByAccount(account);
    }*/

    /**
     * 查询
     * 通过昵称查询
     *
     * @param nickname
     * @return
     */
    /*@GetMapping(value = "/users/nickname/{nickname}")
    public List<User> userListByNickname(@PathVariable("nickname") String nickname) {
        return userRepository.findByNickname(nickname);
    }*/

    /**
     * 修改
     * 根据查询id来修改信息
     *
     * @param user_id
     * @param password
     * @param nickname
     * @param tel
     * @return
     */
    /*@PutMapping(value = "/users/{user_id}")
    public User modifyUserById(@PathVariable("user_id") int user_id,
                               @RequestParam(value = "account", required = true) String account,
                               @RequestParam(value = "password", required = true) String password,
                               @RequestParam(value = "nickname", required = true) String nickname,
                               @RequestParam(value = "tel", required = true) String tel) {
        User user = new User();
        user.setUser_id(user_id);
        user.setAccount(account);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setTel(tel);

        return userRepository.save(user);
    }*/

    /**
     * 删除
     * 根据id删除
     *
     * @param user_id
     */
    /*@DeleteMapping(value = "/user/{user_id}")
    public void deleteUserById(@PathVariable("user_id") int user_id) {
        userRepository.deleteById(user_id);
    }*/

}









