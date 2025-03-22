package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;


public class ExampleTest {

    @Test
    public void sampleTest() {
        //testing Direction enum
        Direction a = Direction.WEST;

        assertTrue(a.toString() == "W");
        assertTrue(a.toVector()[0] == -1 && a.toVector()[1] == 0);

        //testing Decision class
        Decision b = new Decision("fly");
        Decision c = new Decision("heading", Direction.EAST);

        JSONObject tempJSON = b.getDecision();
        assertTrue(tempJSON.getString("action") == "fly");
        tempJSON = c.getDecision();
        assertTrue(tempJSON.getString("action") == "heading" && tempJSON.getJSONObject("parameters").getString("direction") == "E");

        //testing Phase
        Phase d = new PhaseFindIsland();
        d.fly();
        d.turn(Direction.RIGHT);
        d.tightTurn((Direction.LEFT));
        d.wideTurn((Direction.RIGHT));
        d.echo(Direction.LEFT);
        d.scan();
        assertTrue(d.getDecision().getDecision().getString("action") == "fly");
        assertTrue(d.getDecision().getDecision().getJSONObject("parameters").getString("direction") == "R");
        assertTrue(d.getDecision().getDecision().getString("action") == "fly" &&
                   d.getDecision().getDecision().getJSONObject("parameters").getString("direction") == "R" &&
                   d.getDecision().getDecision().getString("action") == "heading" &&
                   d.getDecision().getDecision().getJSONObject("parameters").getString("direction") == "R" &&
                   d.getDecision().getDecision().getString("action") == "fly");
        assertTrue(d.getDecision().getDecision().getString("action") == "fly" &&
                   d.getDecision().getDecision().getString("action") == "heading" &&
                   d.getDecision().getDecision().getJSONObject("parameters").getString("direction") == "R" &&
                   d.getDecision().getDecision().getString("action") == "heading");
        assertTrue(d.getDecision().getDecision().getString("action") == "echo");
        assertTrue(d.getDecision().getDecision().getString("action") == "scan");


        //testing ResultEcho
        tempJSON = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        ResultEcho e = new ResultEcho(tempJSON);
        assertTrue(e.isOK());
        assertTrue(e.groundFound());
        assertTrue(e.getCost() == 1);
        assertTrue(e.getDistance() == 2);
    }


}
