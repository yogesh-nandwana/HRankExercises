package com.na.designpattens.behavioral;

interface IVehicleSimulator {
	void start();
	void operate();
	void stop();
}

interface IOperatingStrategy {
	void operate();
}

class VehicleSimulator implements IVehicleSimulator {
	private IOperatingStrategy operatingStrategy;

	public VehicleSimulator(IOperatingStrategy operatingStrategy) {
		this.operatingStrategy = operatingStrategy;
	}

	@Override
	public void start() {
		System.out.println("Engine started");
	}

	@Override
	public void stop() {
		System.out.println("Engine stopped");
	}

	@Override
	public void operate() {
		operatingStrategy.operate();
	}
}

class CarSimulator extends VehicleSimulator {
	public CarSimulator(IOperatingStrategy operatingStrategy) {
		super(operatingStrategy);
	}
}

class AirplaneSimulator extends VehicleSimulator {
	public AirplaneSimulator(IOperatingStrategy operatingStrategy) {
		super(operatingStrategy);
	}
}

class CruiseShipSimulator extends VehicleSimulator {
	public CruiseShipSimulator(IOperatingStrategy operatingStrategy) {
		super(operatingStrategy);
	}
}


class CarOperatingStrategyImpl implements IOperatingStrategy {
	@Override
	public void operate() {
		System.out.println("Car is being driven now");
	}
}
class CruiseShipOperatingStrategyImpl implements IOperatingStrategy {
	@Override
	public void operate() {
		System.out.println("CruiseShip is being navigated now");
	}
}
class AirPlaneOperatingStrategyImpl implements IOperatingStrategy {
	@Override
	public void operate() {
		System.out.println("Airplane is flying now");
	}
}

public class StrategyDesignPattenTest {
	public static void main(String[] args) {
		VehicleSimulator[] simulators = {
				new CarSimulator(new CarOperatingStrategyImpl()),
				new AirplaneSimulator(new AirPlaneOperatingStrategyImpl()),
				new CruiseShipSimulator(new CruiseShipOperatingStrategyImpl())
		};
		for (VehicleSimulator simulator : simulators){
			simulator.operate();
		}
	}
}