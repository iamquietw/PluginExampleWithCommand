package quietw.example;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

// Наследуем нашим главным классом класс JavaPlugin, которая обозначает, что этот класс - главный класс плагина
// Также подключаем сюда Listener (прослушка ивентов)
public class Main extends JavaPlugin implements Listener {

    // Метод, выполняем при запуске плагина
    public void onEnable() {
        // Регистрируем ивенты
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    // То, что будет происходить при выполнении команды (команда должна быть записана в plugin.yml)
    // Аргументы метода: (отправитель, команда, названиеКоманды, аргументы(массив) )
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("privet")) {
            // Проверяем есть ли у отправителя право example.permission
            if(sender.hasPermission("example.permission")) {
                // Если есть - отправляем сообщение
                sender.sendMessage("Привет");
            } else {
                // Если нет - отправляем другое сообщение
                sender.sendMessage("Пока");
            }
            // Возвращаем true, если команда та
            return true;
        }
        // Возвращаем false, если команда не та
        return false;
    }
}
