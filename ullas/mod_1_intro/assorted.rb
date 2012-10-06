class Array
  def bubble_sort
    sorted = self.dup
    (sorted.length-1).downto(0) do
      |i|
      0.upto(i-1) do
        |j|
         if sorted[j] > sorted[j+1]
           sorted[j], sorted[j+1] = sorted[j+1], sorted[j]
         end
      end
    end
    sorted
  end
end
