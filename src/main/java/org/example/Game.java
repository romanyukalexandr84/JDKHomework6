package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor

//у игры есть параметр, будет ли игрок менять изначальный выбор двери; есть результат игры и метод запуска
public class Game {
    private boolean playerChangedDoor;
    private boolean winResult;

    public void startGame() {
        //создаем список из трех пустых дверей
        List<Door> doors = new ArrayList<>(3);
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(false));

        //за одну из дверей рандомно помещаем приз
        int prizeDoorIndex = new Random().nextInt(3);
        doors.get(prizeDoorIndex).setHasPrize(true);

        //игрок делает рандомный выбор в пользу одной из дверей
        int choiceDoorIndex = new Random().nextInt(3);
        Door playerChoice = doors.remove(choiceDoorIndex);

        //ведущий знает, за какой из дверей приз. Если игрок выбрал дверь с призом, то ведущий рандомно
        //открывает одну из двух оставшихся дверей. Если игрок выбрал дверь без приза, то из двух
        //оставшихся дверей ведущий открывает ту, за которой нет приза
        if (playerChoice.isHasPrize()) {
            doors.remove(new Random().nextInt(2));
        } else {
            if (!doors.get(0).isHasPrize()) {
                doors.remove(0);
            } else {
                doors.remove(1);
            }
        }

        //ведущий предлагает игроку изменить выбор. Если игрок меняет изначальный выбор, то результатом
        //выбора будет оставшаяся дверь. Если не меняет, то результат выбора останется прежним.
        //Далее ведущий открывает дверь (проверяем параметр hasPrize) и получаем результат игры
        if (playerChangedDoor) {
            winResult = doors.get(0).isHasPrize();
        } else {
            winResult = playerChoice.isHasPrize();
        }
    }
}
