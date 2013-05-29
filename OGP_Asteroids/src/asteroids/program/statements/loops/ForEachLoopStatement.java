package asteroids.program.statements.loops;

import java.util.ArrayList;

import asteroids.model.programs.parsing.ProgramFactory;
import asteroids.model.programs.parsing.ProgramFactory.ForeachType;
import asteroids.program.ProgramContainer;
import asteroids.program.statements.*;
import asteroids.program.types.*;
import asteroids.studentdefined.*;

public class ForEachLoopStatement extends LoopStatement {
	private String variableName;
	private ForeachType foreachEnum;
	private int IIC = 0;
	private ArrayList<SpaceObject> spaceObjectList = new ArrayList<SpaceObject>();
	public ForEachLoopStatement(int line, int column, asteroids.model.programs.parsing.ProgramFactory.ForeachType type,
			String variableName, Statement body) {
		super(line,column,body);
		this.variableName = variableName;
		this.foreachEnum = type;
	}
	public void setSource(Program sourceProgram){
		this.sourceProgram = sourceProgram;
		this.body.setSource(sourceProgram);
	}
	@Override
	public boolean execute() {
		World world = getSourceProgram().getSourceShip().getWorld();
		boolean success = false;
		if(spaceObjectList.isEmpty()){
			IIC = 0;
			switch(foreachEnum){
			case SHIP:
				spaceObjectList.addAll(world.getAllShips());
				break;
			case ASTEROID:
				spaceObjectList.addAll(world.getAllAsteroids());
				break;
			case BULLET:
				spaceObjectList.addAll(world.getAllBullets());
				break;
			case POWERUP:
				spaceObjectList.addAll(world.getAllPowerUps());
				break;
			case ANY:
				spaceObjectList.addAll(world.getAllSpaceObjects());
				break;
			}
			if(spaceObjectList.isEmpty()){
				return true;
			}
		}
		for(int i = IIC; i < spaceObjectList.size(); i++){
			this.setEntity(spaceObjectList.get(i));
			success = body.execute();
			if(!success){
				IIC = i;
				break;
			}else{
				IIC++;
				if(IIC >= spaceObjectList.size()){
					spaceObjectList.clear();
					success = true;
				}
			}
		}
		return success;
	}
	public void setEntity(SpaceObject entity){
		ProgramContainer.setGlobal(variableName, new EntityType(entity));
	}
}
