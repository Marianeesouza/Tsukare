package comands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.lang.reflect.Array;
import java.util.List;

public class tictactoe implements ICommand{

    @Override
    public String getName() {
        return "tictactoe";
    }

    @Override
    public String getDescription() {
        return "jogue uma partida de jogo da velha";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        boolean player1 = true;
        boolean playing = true;
        while (playing) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (board[x][y].equals(" ")) {
                if (player1) {
                    board[x][y] = "X";
                } else {
                    board[x][y] = "O";
                }
                player1 = !player1;
            }
            event.reply("```" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n" + board[1][0]
                    + "|" + board[1][1] + "|" + board[1][2] + "\n" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "```").queue();
            playing = false;
            try {
                event.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        event.reply("```" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n" + board[1][0]
                + "|" + board[1][1] + "|" + board[1][2] + "\n" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "```").queue();
    }
}
