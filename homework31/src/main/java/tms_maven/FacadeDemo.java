package tms_maven;


class CPU {
    void start() {
        System.out.println("CPU запущен");
    }
    void stop() {
        System.out.println("CPU остановлен");
    }
}

class Memory {
    void load() {
        System.out.println("Память загружена");
    }
    void free() {
        System.out.println("Память освобождена");
    }
}

class HardDrive {
    void read() {
        System.out.println("Чтение с диска");
    }
    void write() {
        System.out.println("Запись на диск");
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    void start() {
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Компьютер запущен");
    }

    void shutdown() {
        hardDrive.write();
        memory.free();
        cpu.stop();
        System.out.println("Компьютер выключен");
    }
}

public class FacadeDemo {
    public static void main() {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
        computer.shutdown();
    }
}

