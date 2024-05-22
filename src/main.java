import comands.ping;
import comands.roll;
import comands.sum;
import comands.tictactoe;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class main {
    static JDA jda;

    public static void main(String[] args) {
        String token = "MTI0MTAxMDgwODkxNDE4NjI3MQ.G0eaWp.v8dmjbR33zYeFSdges9flK9PLN7G_-nyq6H4Ns";
        jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.DIRECT_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.GUILD_MEMBERS,GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.MESSAGE_CONTENT).build();
        ComandManager commandsManager = new ComandManager();
        commandsManager.addCommand(new sum());
        commandsManager.addCommand(new roll());
        commandsManager.addCommand(new ping());
        commandsManager.addCommand(new tictactoe());
        jda.addEventListener(commandsManager);



    }
}
