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

  def selection_sort
    sorted = self.dup
    0.upto(sorted.length-1) do
      |i|
      min = sorted[i]
      i.upto(sorted.length-1) do
        |j|
        if min > sorted[j]
          min, sorted[j] = sorted[j], min
        end
      end
      sorted[i] = min
    end
    sorted
  end
end
