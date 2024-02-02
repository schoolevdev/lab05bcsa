// Lab05bvst.java
// Evin Lodder
// Open-Ended Writing Classes Assignment
// This Lab creates a PC class that contains data for all of the internal parts
// 2/1/2024

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 2 Builds will be constructed: my personal build and a budget build.
        //The budget build will not have enough wattage
        Cpu myCpu = new Cpu(
                349.99,
                "AMD Ryzen 7 7800x3D",
                4.2,
                120
        );
        Cooler myCooler = new Cooler(
                54.99,
                "Deepcool AK620",
                500,
                1850,
                28,
                "White",
                160
        );
        Motherboard myMobo = new Motherboard(
                204.99,
                "Gigabyte B650 AORUS Elite AX Ice",
                "AM5",
                "ATX",
                "B650",
                true,
                "DDR5"
        );
        Ram myRam = new Ram(
                113.99,
                "G.Skill Trident Z5 NEO RGB",
                6000,
                32,
                30,
                "White"
        );
        Gpu myGpu = new Gpu(
                879.99,
                "Gigabyte AERO OC RTX 4070 Ti Super",
                16,
                2655,
                "White",
                300,
                285
        );
        Case myCase = new Case(
                84.99,
                "Lian Li Lancool 2 Mesh",
                "White",
                "ATX"
        );
        Psu myPsu = new Psu(
                74.99,
                "Corsair RM750e",
                750,
                true
        );
        ArrayList<Storage> myStorages = new ArrayList<>();
        myStorages.add(new Storage(139.99, "SK Hynix Platinum P41", 2000));
        ArrayList<Monitor> myMonitors = new ArrayList<>();
        myMonitors.add(new Monitor(219.99, "Acer Nitro XV272U", "2560x1440", 180, 27, 0.5, "IPS", 350, true));
        myMonitors.add(new Monitor(219.99, "Acer Nitro XV272U", "2560x1440", 180, 27, 0.5, "IPS", 350, true));

        //create Pc with all the parts and display it
        Pc myPc = new Pc("My build!", myCpu, myCooler, myMobo, myRam, myStorages, myGpu, myCase, myPsu, myMonitors);
        System.out.print(myPc.buildSpecs());

        //now budget build
        Cpu budgetCpu = new Cpu(
                152.99,
                "AMD Ryzen 5 5600x",
                3.7,
                65
        );
        Cooler budgetCooler = new Cooler(
                33.9,
                "Thermalight Peerless Assassin",
                1550,
                1550,
                25.6,
                "Black",
                155
        );
        Motherboard budgetMobo = new Motherboard(
                109.99,
                "MSI B550 Gaming GEN3",
                "AM4",
                "ATX",
                "B550",
                false,
                "DDR4"
        );
        Ram budgetRam = new Ram(
                41.99,
                "Corsair Vengeance LPX",
                3200,
                16,
                16,
                "Black"
        );
        Gpu budgetGpu = new Gpu(
                283.39,
                "MSI RTX 3060 Ventus 2X",
                12,
                1777,
                "Black",
                235,
                170
        );
        Case budgetCase = new Case(
                54.99,
                "Montech X3 Mesh",
                "Black",
                "ATX"
        );
        Psu budgetPsu = new Psu(
                31.99,
                "Apevia CAPTAIN",
                350,
                false
        );
        ArrayList<Storage> budgetStorages = new ArrayList<>();
        budgetStorages.add(new Storage(61.99, "Kingston NV2", 1000));
        ArrayList<Monitor> budgetMonitors = new ArrayList<>();
        budgetMonitors.add(new Monitor(119.89, "Koorui 24E3", "1920x1080", 165, 24, 1, "IPS", 250, true));

        //create Pc with all the parts and display it
        Pc budgetPc = new Pc("My build!", budgetCpu, budgetCooler, budgetMobo, budgetRam, budgetStorages, budgetGpu, budgetCase, budgetPsu, budgetMonitors);
        System.out.print("\n" + budgetPc.buildSpecs());

        //create Pc with empty ctor
        Pc empty = new Pc();
        //System.out.print("\n" + empty.buildSpecs()); THIS WILL THROW AN ERROR BECAUSE THE PARTS AREN'T SET YET
    }
}

class Pc {
    //name of PC build
    private String name;
    private int wattage;
    private Cpu cpu;
    private Cooler cooler;
    private Motherboard motherboard;
    private Ram ram;
    private ArrayList<Storage> storages;
    private Gpu gpu;
    private Case cse; //can't call it case because that is a keyword
    private Psu psu;
    private ArrayList<Monitor> monitors;

    //sets primitive defaults. can't set others to default because they don't have a well-defined default per se
    Pc() {
        this.name = "";
        this.wattage = 0;
        this.storages = new ArrayList<>();
        this.monitors = new ArrayList<>();
    }

    public Pc(String name, Cpu cpu, Cooler cooler, Motherboard motherboard, Ram ram, ArrayList<Storage> storages, Gpu gpu, Case cse, Psu psu, ArrayList<Monitor> monitors) {
        this.name = name;
        //to deep copy we need to continue this process for every part
        //this, by the way, is why java is a stupid language. other languages don't automatically send pointers around without telling the user
        this.cpu = new Cpu(
                cpu.getPrice(),
                cpu.getName(),
                cpu.getClockSpeed(),
                cpu.getWattage()
        );
        this.cooler = new Cooler(
                cooler.getPrice(),
                cooler.getName(),
                cooler.getMinRpm(),
                cooler.getMaxRpm(),
                cooler.getNoiseLevel(),
                cooler.getColor(),
                cooler.getHeight()
        );
        this.motherboard = new Motherboard(
                motherboard.getPrice(),
                motherboard.getName(),
                motherboard.getSocket(),
                motherboard.getFormFactor(),
                motherboard.getChipset(),
                motherboard.hasBuiltInWifi(),
                motherboard.getMemoryType()
        );
        this.ram = new Ram(
                ram.getPrice(),
                ram.getName(),
                ram.getSpeed(),
                ram.getSize(),
                ram.getLatency(),
                ram.getColor()
        );
        this.gpu = new Gpu(
                gpu.getPrice(),
                gpu.getName(),
                gpu.getVram(),
                gpu.getClockSpeed(),
                gpu.getColor(),
                gpu.getLength(),
                gpu.getWattage()
        );
        this.cse = new Case(
                cse.getPrice(),
                cse.getName(),
                cse.getColor(),
                cse.getFormFactor()
        );
        this.psu = new Psu(
                psu.getPrice(),
                psu.getName(),
                psu.getWattage(),
                psu.isModular()
        );
        //initialize empty arraylists then add each individual element to each
        this.storages = new ArrayList<>();
        for (Storage storage : storages) {
            this.storages.add(new Storage(
                    storage.getPrice(),
                    storage.getName(),
                    storage.getGigabytes()
            ));
        }
        this.monitors = new ArrayList<>();
        for (Monitor monitor : monitors) {
            this.monitors.add(new Monitor(
                    monitor.getPrice(),
                    monitor.getName(),
                    monitor.getResolution(),
                    monitor.getRefreshRate(),
                    monitor.getScreenSize(),
                    monitor.getResponseTime(),
                    monitor.getPanelType(),
                    monitor.getBrightness(),
                    monitor.hasFrameSync()
            ));
        }
        this.wattage = this.cpu.getWattage() + this.gpu.getWattage();
    }

    public String getName() {
        return name;
    }

    public int getWattage() {
        return wattage;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Cooler getCooler() {
        return cooler;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public Ram getRam() {
        return ram;
    }

    public ArrayList<Storage> getStorages() {
        return storages;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public Case getCse() {
        return cse;
    }

    public Psu getPsu() {
        return psu;
    }

    public ArrayList<Monitor> getMonitors() {
        return monitors;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    //once again, deep copy for all setters
    public void setCpu(Cpu cpu) {
        //don't forget to change wattage variable
        this.wattage -= this.cpu.getWattage();
        this.cpu = new Cpu(
                cpu.getPrice(),
                cpu.getName(),
                cpu.getClockSpeed(),
                cpu.getWattage()
                );
        this.wattage += this.cpu.getWattage();
    }

    public void setCooler(Cooler cooler) {
        this.cooler = new Cooler(
                cooler.getPrice(),
                cooler.getName(),
                cooler.getMinRpm(),
                cooler.getMaxRpm(),
                cooler.getNoiseLevel(),
                cooler.getColor(),
                cooler.getHeight()
                );
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = new Motherboard(
                motherboard.getPrice(),
                motherboard.getName(),
                motherboard.getSocket(),
                motherboard.getFormFactor(),
                motherboard.getChipset(),
                motherboard.hasBuiltInWifi(),
                motherboard.getMemoryType()
                );
    }

    public void setRam(Ram ram) {
        this.ram = new Ram(
            ram.getPrice(),
            ram.getName(),
            ram.getSpeed(),
                ram.getSize(),
                ram.getLatency(),
                ram.getColor()
                );
    }

    public void setStorages(ArrayList<Storage> storages) {
        this.storages = new ArrayList<>();
        for (Storage storage : storages) {
            this.storages.add(new Storage(
                    storage.getPrice(),
                    storage.getName(),
                    storage.getGigabytes()
            ));
        }
    }

    public void setGpu(Gpu gpu) {
        //don't forget to change wattage variable
        this.wattage -= this.gpu.getWattage();
        this.gpu = new Gpu(
                gpu.getPrice(),
                gpu.getName(),
                gpu.getVram(),
                gpu.getClockSpeed(),
                gpu.getColor(),
                gpu.getLength(),
                gpu.getWattage()
                );
        this.wattage += this.gpu.getWattage();
    }

    public void setCse(Case cse) {
        this.cse = new Case(
                cse.getPrice(),
                cse.getName(),
                cse.getColor(),
                cse.getFormFactor()
                );
    }

    public void setPsu(Psu psu) {
        this.psu = new Psu(
                psu.getPrice(),
                psu.getName(),
                psu.getWattage(),
                psu.isModular()
                );
    }

    public void setMonitors(ArrayList<Monitor> monitors) {
        this.monitors = new ArrayList<>();
        for (Monitor monitor : monitors) {
            this.monitors.add(new Monitor(
                    monitor.getPrice(),
                    monitor.getName(),
                    monitor.getResolution(),
                    monitor.getRefreshRate(),
                    monitor.getScreenSize(),
                    monitor.getResponseTime(),
                    monitor.getPanelType(),
                    monitor.getBrightness(),
                    monitor.hasFrameSync()
            ));
        }
    }

    // generally, you want a decent amount of leeway with PSU wattage in case it spikes or you overclock.
    // I'll make this leeway 1.5x the total wattage draw
    private boolean hasEnoughWattage() {
        return (wattage * 1.5) <= this.psu.getWattage();
    }
    //get total price of everything
    private double getTotalPrice() {
        double price = this.cpu.getPrice() + this.cooler.getPrice() + this.motherboard.getPrice() + this.ram.getPrice() + this.gpu.getPrice() + this.cse.getPrice() + this.psu.getPrice();
        for (Storage storage : storages) {
            price += storage.getPrice();
        }
        for (Monitor monitor : monitors) {
            price += monitor.getPrice();
        }
        return price;
    }
    //Displays all of the information about the build
    public String buildSpecs() {
        StringBuilder stringBuilder = new StringBuilder();
        // The IDE wanted me to chain appends instead of concat strings
        stringBuilder.append("Build name: ").
                append(name).
                append("\n");
        stringBuilder.
                append("Total wattage: ").
                append(wattage).
                append(" W\n");
        //if there is wattage error, add it to info
        if(!hasEnoughWattage()) {
            stringBuilder.append("NOTE: PSU NEEDS MORE WATTAGE!\n" + "Target wattage: ")
                    .append(wattage * 1.5)
                    .append("W\n")
                    .append("Current PSU wattage: ")
                    .append(psu.getWattage())
                    .append("W\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("CPU:\n\t" + "Name: ").
                append(cpu.getName()).
                append("\n\t").
                append("Price: $").
                append(cpu.getPrice()).
                append("\n\t").
                append("Clock Speed: ").
                append(cpu.getClockSpeed()).
                append("GHz\n\t").append("Wattage: ").
                append(cpu.getWattage()).
                append("W\n\n");

        stringBuilder.append("Cooler:\n\t" + "Name: ").
                append(cooler.getName()).
                append("\n\t").append("Price: $").
                append(cooler.getPrice()).
                append("\n\t").
                append("Fan Speed: ").
                append(cooler.getMinRpm()).
                append(" - ").
                append(cooler.getMaxRpm()).
                append("RPM\n\t").
                append("Noise Level: ").
                append(cooler.getNoiseLevel()).
                append("db\n\t").
                append("Color: ").
                append(cooler.getColor()).
                append("\n\t").
                append("Height: ").
                append(cooler.getHeight()).
                append("mm\n\n");
        stringBuilder.append("Motherboard:\n\tName: ").
                append(motherboard.getName()).
                append("\n\tPrice: $").
                append(motherboard.getPrice()).
                append("\n\tSocket: ").
                append(motherboard.getSocket()).
                append("\n\tForm Factor: ").
                append(motherboard.getFormFactor()).
                append("\n\tChipset: ").
                append(motherboard.getChipset()).
                append("\n\tWifi?: ").
                append(motherboard.hasBuiltInWifi()).
                append("\n\tMemory Type: ").
                append(motherboard.getMemoryType()).
                append("\n\n");
        stringBuilder.append("Ram:\n\tName: ")
                .append(ram.getName())
                .append("\n\tPrice: $")
                .append(ram.getPrice())
                .append("\n\tSpeed: ")
                .append(ram.getSpeed())
                .append("mT/s\n\tSize: ")
                .append(ram.getSize())
                .append("GB\n\tCAS Latency: ")
                .append(ram.getLatency())
                .append("ms\n\tColor: ")
                .append(ram.getColor())
                .append("\n\n");
        //add storages to stringBuilder in a loop
        for(int i = 0; i < storages.size(); i++) {
            Storage storage = storages.get(i);
            stringBuilder.append("Storage ")
                    .append(i)
                    .append(":\n\tName: ")
                    .append(storage.getName())
                    .append("\n\tPrice: $")
                    .append(storage.getPrice())
                    .append("\n\tStorage: ")
                    .append(storage.getGigabytes())
                    .append("GB\n\n");
        }
        stringBuilder.append("Case:\n\tName: ")
                .append(cse.getName())
                .append("\n\tPrice: $")
                .append(cse.getPrice())
                .append("\n\tColor: ")
                .append(cse.getColor())
                .append("\n\tForm Factor: ")
                .append(cse.getFormFactor())
                .append("\n\n");
        stringBuilder.append("PSU:\n\tName: ")
                .append(psu.getName())
                .append("\n\tPrice: $")
                .append(psu.getPrice())
                .append("\n\tWattage: ")
                .append(psu.getWattage())
                .append("W\n\tModular?: ")
                .append(psu.isModular())
                .append("\n\n");
        //also add monitors in a loop
        for(int i = 0; i < monitors.size(); i++) {
            Monitor monitor = monitors.get(i);
            stringBuilder.append("Monitor ")
                    .append(i)
                    .append(":\n\tName: ")
                    .append(monitor.getName())
                    .append("\n\tPrice: $")
                    .append(monitor.getPrice())
                    .append("\n\tResolution: ")
                    .append(monitor.getResolution())
                    .append("p\n\tRefresh Rate: ")
                    .append(monitor.getRefreshRate())
                    .append("Hz\n\tScreen Size: ")
                    .append(monitor.getScreenSize())
                    .append("\"\n\tResponse Time: ")
                    .append(monitor.getResponseTime())
                    .append("ms\n\tPanel Type: ")
                    .append(monitor.getPanelType())
                    .append("\n\tBrightness: ")
                    .append(monitor.getBrightness())
                    .append("nits\n\tHas Frame Sync?: ")
                    .append(monitor.hasFrameSync())
                    .append("\n\n");

        }
        //finally, print total cost + sales tax
        double totalPrice = getTotalPrice();
        stringBuilder.append("Total Price: $")
                .append(Math.round(totalPrice * 100) / (double)100)
                .append("\n");
        stringBuilder.append("Sales Tax: $")
                .append(Math.round(totalPrice * 0.0575 * 100) / (double)100)
                .append("\n");
        stringBuilder.append("Total Price with Sales Tax: $")
                .append(Math.round(totalPrice * 1.0575 * 100) / (double)100);
        return stringBuilder.toString();
    }
}

//CPU class to define important CPU specs
class Cpu {
    private final double price;
    private final String name;
    private final double clockSpeed; //the speed of the internal CPU clock, in GHz
    private final int wattage;

    Cpu(double price, String name, double clockSpeed, int wattage) {
        this.price = price;
        this.name = name;
        this.clockSpeed = clockSpeed;
        this.wattage = wattage;
    }

    // getters for fields
    // I am intentionally leaving out setters because I believe once the object is made, the data shouldn't be changed
    // e.g. it wouldn't make sense to have the wattage of a CPU changed after the object is initialized because that isn't realistic
    // NOTE: THIS WILL BE THE CASE FOR ALL SUBCLASSES. I WILL NOT WrITe ThIS COMMENT AGAIN
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public double getClockSpeed() {
        return clockSpeed;
    }
    public int getWattage() {
        return wattage;
    }
}

//CPU cooler class to define important CPU cooler specs
class Cooler {
    private final double price;
    private final String name;
    private final int minRpm; // min and max speeds both in RPM
    private final int maxRpm;
    private final double noiseLevel; // in db
    private final String color; //I don't feel like making a color enum rn tbh
    private final int height; // in mm

    Cooler(double price, String name, int minRpm, int maxRpm, double noiseLevel, String color, int height) {
        this.price = price;
        this.name = name;
        this.minRpm = minRpm;
        this.maxRpm = maxRpm;
        this.noiseLevel = noiseLevel;
        this.color = color;
        this.height = height;
    }


    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public int getMinRpm() {
        return minRpm;
    }

    public double getNoiseLevel() {
        return noiseLevel;
    }

    public int getMaxRpm() {
        return maxRpm;
    }

    public String getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }
}

//Motherboard class containing important motherboard specs
class Motherboard {
    private final double price;
    private final String name;
    private final String socket; //AM4, AM5, LGA1700, etc
    private final String formFactor; //ATX, MATX, ITX, etc
    private final String chipset; //Z790, B650, etc
    private final boolean hasBuiltInWifi;
    private final String memoryType; //DDR5 or DDR4

    Motherboard(double price, String name, String socket, String formFactor, String chipset, boolean hasBuiltInWifi, String memoryType) {
        this.price = price;
        this.name = name;
        this.socket = socket;
        this.formFactor = formFactor;
        this.chipset = chipset;
        this.hasBuiltInWifi = hasBuiltInWifi;
        this.memoryType = memoryType;
    }

    public boolean hasBuiltInWifi() {
        return hasBuiltInWifi;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getSocket() {
        return socket;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public String getChipset() {
        return chipset;
    }
}

// Ram class that contains important ram specs
class Ram {
    private final double price;
    private final String name;
    private final int speed; //MT per S
    private final int size; //GB
    private final int latency; //CAS LATENCY, ms
    private final String color;

    Ram(double price, String name, int speed, int size, int latency, String color) {
        this.price = price;
        this.name = name;
        this.speed = speed;
        this.size = size;
        this.latency = latency;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSize() {
        return size;
    }

    public int getLatency() {
        return latency;
    }

    public String getColor() {
        return color;
    }
}

//Storage interface (not too much useful in it)
class Storage {
    private final double price;
    private final String name;
    private final int gigabytes;

    Storage(double price, String name, int gigabytes) {
        this.price = price;
        this.name = name;
        this.gigabytes = gigabytes;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getGigabytes() {
        return gigabytes;
    }
}

//GPU interface for important GPU specs
class Gpu {
    private final double price;
    private final String name;
    private final int vram; //video ram on card
    private final int clockSpeed; //internal card clock speed
    private final String color;
    private final int length;
    private final int wattage;

    Gpu(double price, String name, int vram, int clockSpeed, String color, int length, int wattage) {
        this.price = price;
        this.name = name;
        this.vram = vram;
        this.clockSpeed = clockSpeed;
        this.color = color;
        this.length = length;
        this.wattage = wattage;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getVram() {
        return vram;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public String getColor() {
        return color;
    }

    public int getLength() {
        return length;
    }

    public int getWattage() {
        return wattage;
    }
}

//Case interface for case specs
class Case {
    private final double price;
    private final String name;
    private final String color;
    private final String formFactor;

    Case(double price, String name, String color, String formFactor) {
        this.price = price;
        this.name = name;
        this.color = color;
        this.formFactor = formFactor;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getFormFactor() {
        return formFactor;
    }
}

// PSU interface for valuable PSU specs
class Psu {
    private final double price;
    private final String name;
    private final int wattage;
    private final boolean modular; //most good quality PSUs are modular

    Psu(double price, String name, int wattage, boolean modular) {
        this.price = price;
        this.name = name;
        this.wattage = wattage;
        this.modular = modular;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getWattage() {
        return wattage;
    }

    public boolean isModular() {
        return modular;
    }
}

// Monitor interface that defines important monitor specs
class Monitor {
    private final double price;
    private final String name;
    private final String resolution; //number of pixels on screen (1920x1080, 2560x1440, etc.)
    private final int refreshRate; //max FPS monitor can handle
    private final double screenSize; //diagonal
    private final double responseTime; //how fast monitor registers input and color changes
    private final String panelType; //IPS, VA, OLED, etc.
    private final int brightness; //how bright the pixels can get
    private final boolean hasFrameSync; //to prevent screen tearing

    Monitor(double price, String name, String resulution, int refreshRate, double screenSize, double responseTime, String panelType, int brightness, boolean hasFrameSync) {
        this.price = price;
        this.name = name;
        this.resolution = resulution;
        this.refreshRate = refreshRate;
        this.screenSize = screenSize;
        this.responseTime = responseTime;
        this.panelType = panelType;
        this.brightness = brightness;
        this.hasFrameSync = hasFrameSync;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getResolution() {
        return resolution;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public String getPanelType() {
        return panelType;
    }

    public int getBrightness() {
        return brightness;
    }

    public boolean hasFrameSync() {
        return hasFrameSync;
    }
}