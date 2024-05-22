package comands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class roll implements ICommand{

        @Override
        public String getName() {
            return "roll";
        }

        @Override
        public String getDescription() {
            return "Roll a dice";
        }

        @Override
        public List<OptionData> getOptions() {
            ArrayList<OptionData> options = new ArrayList<>();
            options.add(new OptionData(OptionType.INTEGER, "dado", "The dice to be rolled", true));
            options.add(new OptionData(OptionType.INTEGER, "quantidade", "The amount of dice to be rolled", false));
            options.add(new OptionData(OptionType.INTEGER, "modificador", "The modifier to be added to the result", false));
            return options;
        }

        @Override
        public void execute(SlashCommandInteractionEvent event) {
            if (event.getName().equals("roll")) {
                OptionMapping quantidade = event.getOption("quantidade");
                int quantidadeValue;
                if (quantidade != null) {
                    quantidadeValue = quantidade.getAsInt();
                } else {
                    quantidadeValue = 1;
                }
                OptionMapping dado = event.getOption("dado");
                int dadoValue = dado.getAsInt();
                OptionMapping modificador = event.getOption("modificador");
                int modificadorValue;
                if (modificador != null) {
                    modificadorValue = modificador.getAsInt();
                } else {
                    modificadorValue = 0;
                }
                int result = 0;
                ArrayList<Integer> rolls = new ArrayList<>();
                for (int i = 0; i < quantidadeValue; i++) {
                    int lado = (int) (Math.random() * dadoValue + 1);
                    result += lado;
                    rolls.add(lado);
                }
                rolls.sort(null);
                StringBuilder rollsString = new StringBuilder();
                rollsString.append("Rolled ").append(quantidadeValue).append("d").append(dadoValue).append(": [");
                for (int i = 0; i < rolls.size(); i++) {
                    rollsString.append(rolls.get(i));
                    if (i < rolls.size() - 1) {
                        rollsString.append(", ");
                    }
                }
                result += modificadorValue;
                if (modificadorValue < 0) {
                    rollsString.append("] - ").append(-modificadorValue).append(" → ").append(result);
                } else if (modificadorValue == 0) {
                    rollsString.append("] → ").append(result);
                } else {
                    rollsString.append("] + ").append(modificadorValue).append(" → ").append(result);
                }
                event.reply(rollsString.toString()).queue();
            } else {
                return;
            }
        }

}
