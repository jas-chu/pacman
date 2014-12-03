package com.tdd.application.game;

import com.tdd.application.configuration.LevelConfigurations;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.tests.helpers.TestsHelper;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class KeyboardConductedLevelTest {
	
	GameLevel game;
	
    @Before
	public void setUp() {
		LevelConfigurations configs = TestsHelper.createLevelConfigurations(0);
		try {
			this.game = new KeyboardConductedLevel(configs);
		} catch (MalformedXMLException ex) {
			fail();
		}
	}
	
	@Test
	public void getEnemiesTest() {
        List<Enemy> enemies = this.game.getEnemies();
		assert(enemies != null);
		assert(!(enemies.isEmpty()));
    }
	
	@Test
	public void getProtagonistNullTest() {
        assert(this.game.getProtagonist() == null);
		assert(this.game.isEndOfLevel());
    }
	
	@Test
	public void populateWithProtagonistTest() {
		Protagonist pacman = new Pacman();
		PlayerController controller = new KeyboardPlayerController();
		this.game.populateWithProtagonist(pacman, controller);
		assert(this.game.getProtagonist() == pacman);
		assert(!(this.game.isEndOfLevel()));
    }

}