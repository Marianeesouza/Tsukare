package comands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class sum implements ICommand {

    @Override
    public String getName() {return "sum";}

    @Override
    public String getDescription() {return "Sum two numbers";}

    @Override
    public List<OptionData> getOptions() {
        ArrayList<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.INTEGER, "num1", "The first number", true));
        options.add(new OptionData(OptionType.INTEGER, "num2", "The second number", true));
        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (event.getName().equals("sum")) {
            OptionMapping num1 = event.getOption("num1");
            int num1Value = num1.getAsInt();
            OptionMapping num2 = event.getOption("num2");
            int num2Value = num2.getAsInt();
            event.reply("The sum of " + num1Value + " and " + num2Value + " is " + (num1Value + num2Value)).queue();
        } else {
            return;
        }
    }

}
