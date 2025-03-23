package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;


public class ExampleTest {

    @Test
    public void sampleTest() {
        //testing Direction enum
        Direction a = Direction.WEST;

        assertTrue(a.toString().equals("W"));
        assertTrue(a.toVector()[0] == -1 && a.toVector()[1] == 0);

        //testing Decision class
        Decision b = new Decision("fly");
        Decision c = new Decision("heading", Direction.EAST);

        JSONObject tempJSON = b.getJSONObject();
        assertTrue(tempJSON.getString("action").equals("fly"));
        tempJSON = c.getJSONObject();
        assertTrue(tempJSON.getString("action").equals("heading") && 
                   tempJSON.getJSONObject("parameters").getString("direction").equals("E"));

        //testing Phase
        Phase d = new PhaseFindIsland();
        d.fly();
        d.turn(Direction.RIGHT);
        d.tightTurn((Direction.LEFT));
        d.wideTurn((Direction.RIGHT));
        d.echo(Direction.LEFT);
        d.scan();
        assertTrue(d.getDecision().getJSONObject().getString("action").equals("fly"));
        assertTrue(d.getDecision().getJSONObject().getJSONObject("parameters").getString("direction").equals("R"));
        assertTrue(d.getDecision().getJSONObject().getString("action").equals("fly") &&
                   d.getDecision().getJSONObject().getJSONObject("parameters").getString("direction").equals("R") &&
                   d.getDecision().getJSONObject().getString("action").equals("heading") &&
                   d.getDecision().getJSONObject().getJSONObject("parameters").getString("direction").equals("R") &&
                   d.getDecision().getJSONObject().getString("action").equals("fly"));
        assertTrue(d.getDecision().getJSONObject().getString("action").equals("fly") &&
                   d.getDecision().getJSONObject().getString("action").equals("heading") &&
                   d.getDecision().getJSONObject().getJSONObject("parameters").getString("direction").equals("R") &&
                   d.getDecision().getJSONObject().getString("action").equals("heading"));
        assertTrue(d.getDecision().getJSONObject().getString("action").equals("echo"));
        assertTrue(d.getDecision().getJSONObject().getString("action").equals("scan"));


        //testing ResultEcho
        tempJSON = new JSONObject("{ \"range\": 2, \"found\": \"GROUND\" }");
        ResultEcho e = new ResultEcho(1, "OK", tempJSON);
        assertTrue(e.isOK());
        assertTrue(e.groundFound());
        assertTrue(e.getCost() == 1);
        assertTrue(e.getDistance() == 2);
    }


}
