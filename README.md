# Tic-Tac-Toe (Java)
A console-based Tic-Tac-Toe game developed in Java, designed using all core Object-Oriented Programming (OOP) principles.
The project supports multiple game modes, strategic AI players, and an extensible architecture that allows easy feature expansion without modifying existing code.

---

# ✨ Game Modes
The game supports five different modes:
1. Human vs Human
2. Human vs Computer (Random moves)
3. Computer vs Computer (Random moves)
4. Human vs Smart Computer (Strategic moves)
5. Smart Computer vs Smart Computer (Strategic moves)

---

# 🧠 Smart Computer Player
The smart computer player simulates human-like decision-making using rule-based logic rather than random placement:
- Executes winning moves when available
- Blocks the opponent’s winning opportunities
- Prioritizes center control
- Selects corners strategically
This results in more challenging and realistic gameplay.

---

# 📦 Versions Included
Original Version
- Fixed 3×3 grid
- Classic Tic-Tac-Toe rules
- Supports all five game modes

Extended Version
- User-defined grid size (3 <= N <= 20)
- Dynamic win condition based on grid size
- Fully reuses existing classes without modification
- Demonstrates strong adherence to the open–closed principle

---

# 🧩 Object-Oriented Design Principles Used
This project applies all major OOP principles:

🧱 Abstraction
- Player defines a common interface for all player types
  
🧬 Inheritance (Parent–Child Relationship)
- HumanPlayer, ComputerPlayer, and SmartComputerPlayer inherit from Player
- Shared behavior is defined in the parent class and extended in child classes

🔁 Polymorphism
- The game treats all players as Player objects
- Different player behaviors are executed at runtime using dynamic dispatch

🔒 Encapsulation
- Game logic and data are contained within their respective classes

🕶️ Information Hiding
- Internal board representation is hidden from external access
- Only necessary methods are exposed

♻️ Open–Closed Principle
- New features added without modifying existing code

🎯 Single Responsibility Principle
- Each class handles one specific responsibility


