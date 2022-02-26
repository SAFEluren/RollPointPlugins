package safeluren.mcpl.roll.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import safeluren.mcpl.roll.Utils.color;
import safeluren.mcpl.roll.main;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class roll implements CommandExecutor {
    Plugin plugin = main.getPlugin(main.class); //Plugin 变量 方便取用
    String prefix = plugin.getConfig().getString("plugins_prefix"); //插件前缀
    String okay = plugin.getConfig().getString("roll_okay"); //完成的消息
    String error = plugin.getConfig().getString("roll_error"); //错误消息
    String tips_op = plugin.getConfig().getString("roll_only_player");  //仅玩家提醒
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) { // 命令部分
        Random r = new Random(); // random的包重命名为r
        if (sender instanceof Player) { // sender 是否为玩家
            //错误消息 : 长度为零
            if (args.length == 1){
                String i_str = args[0];
                if (judgeAllNum(i_str)) {
                    int i_num = Integer.parseInt(i_str); // 转化整数
                    if (i_num > 0 & i_num < 214748367) { // 输入数字是否大于等于int上限
                        int num = r.nextInt(i_num) + 1; // 随机一个 1 - i_num的数字
                        sender.sendMessage(prefix+okay + num); // 随机完了 发消息
                    } else {
                        sender.sendMessage(color.format(String.format("%s",prefix+error))); // 发给玩家错误消息
                    }
                    return true;
                }
            }
            sender.sendMessage(color.format(String.format("%s",prefix+error))); // 错误消息 : 非纯数字
        } else {
            System.out.println(prefix + tips_op); //后台执行提醒仅玩家可用
        }
        return true;
    }

    public boolean judgeAllNum(String str) { //正则表达式判断是否为纯数字
        String regex="^[0-9]*$";
        Matcher m= Pattern.compile(regex).matcher(str);
        return m.matches();
    }
}
