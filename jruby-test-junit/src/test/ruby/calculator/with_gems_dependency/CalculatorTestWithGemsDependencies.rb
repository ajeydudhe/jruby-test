require_relative '../../../../main/ruby/Calculator'

class CalculatorTestWithGemsDependencies
  def initialize()
    puts 'Created ' + self.class.to_s
  end
  def test_addition()
    cal = Calculator.new
    raise 'add() failed.' until cal.add(1, 2) == 3
  end
end