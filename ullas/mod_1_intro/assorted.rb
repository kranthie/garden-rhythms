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

  def insertion_sort
    sorted = self.dup
    sorted.each_index do
      |i|
      i.downto(1) do
        |j|
        if sorted[j] < sorted[j-1]
          sorted[j], sorted[j-1] = sorted[j-1], sorted[j]
        end
      end
    end
    sorted
  end
  
  def merge_sort(array=self)
    return array if array.size == 1 or array.empty?
    left = merge_sort(array[0...array.size/2])
    right = merge_sort(array[array.size/2...array.size])
    merge(left, right)
  end
  def merge(left, right)
    l, r, sorted = left.dup, right.dup, []
    while not l.empty? and not r.empty? do
      if l[0] <= r[0]
        sorted << l.shift
      else
        sorted << r.shift
      end
    end
    sorted += l if not l.empty?
    sorted += r if not r.empty?
    sorted
  end
end
